import pandas as pd
import mysql.connector
import re

# Leer el archivo Excel
excel_file = 'datos.xlsx'
df = pd.read_excel(excel_file, sheet_name='Ofertas Vigente', engine='openpyxl')

# Conectar a la base de datos MySQL
conn = mysql.connector.connect(
    host='localhost',
    port=3306,
    user='root',
    password='LALA-luxi1',
    database='redsalud2025'
)
cursor = conn.cursor()

# Función para generar correo si está pendiente
def generar_correo(nombre):
    partes = nombre.strip().lower().split()
    if len(partes) >= 2:
        correo = f"{partes[0]}.{partes[-1]}@redsalud.cl"
    else:
        correo = f"{partes[0]}@redsalud.cl"
    correo = re.sub(r'[^a-z0-9.@]', '', correo)
    return correo

# Insertar médicos en la base de datos
insertados = 0
for _, row in df.iterrows():
    nombre = str(row.get('Nombre', '')).strip()
    especialidad = str(row.get('Especialidad', '')).strip()
    correo = str(row.get('Correo', '')).strip()

    if not nombre:
        continue

    if not correo or correo.lower() == 'pendiente':
        correo = generar_correo(nombre)

    try:
        cursor.execute(
            "INSERT IGNORE INTO Medicos (nombre, especialidad, correo) VALUES (%s, %s, %s)",
            (nombre, especialidad, correo)
        )
        if cursor.rowcount > 0:
            insertados += 1
    except Exception as e:
        print(f"Error al insertar {nombre}: {e}")

# Confirmar cambios y cerrar conexión
conn.commit()
cursor.close()
conn.close()

print(f"Se insertaron {insertados} médicos nuevos en la base de datos.")
