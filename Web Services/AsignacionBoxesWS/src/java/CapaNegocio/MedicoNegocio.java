package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Medico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicoNegocio {

    public List<Medico> obtenerTodos() throws InterruptedException {
        System.out.println("Iniciando conexión...");
        ConexionMySQL conexionObtenerTodos = new ConexionMySQL();
        conexionObtenerTodos.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionObtenerTodos.setNombreTabla("medicos");
        conexionObtenerTodos.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionObtenerTodos.setUsuario("root");
        conexionObtenerTodos.setPass("LALA-luxi1");
        conexionObtenerTodos.setCadenaSQL("SELECT * FROM Medicos");
        conexionObtenerTodos.setEsSelect(true);
        conexionObtenerTodos.conectar();
        List<Medico> listaMedico = new ArrayList<>();
        try {
            ResultSet rsMedico = conexionObtenerTodos.getDbresultSet();
            int count = 0;
            while (rsMedico.next()) {
                Medico m = new Medico();
                m.setIdMedico(rsMedico.getInt("id_medico"));
                m.setNombre(rsMedico.getString("nombre"));
                m.setEspecialidad(rsMedico.getString("especialidad"));
                m.setCorreo(rsMedico.getString("correo"));
                listaMedico.add(m);
                count++;
            }
            System.out.println("Médicos encontrados: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionObtenerTodos.cerrar();
        }

        return listaMedico;
    }
    
    public List<String> obtenerEspecialidades(){
        System.out.println("Iniciando conexión (Especialidades)...");
        ConexionMySQL conexionObtenerEspecialidades = new ConexionMySQL();
        conexionObtenerEspecialidades.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionObtenerEspecialidades.setNombreTabla("medicos");
        conexionObtenerEspecialidades.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionObtenerEspecialidades.setUsuario("root");
        conexionObtenerEspecialidades.setPass("LALA-luxi1");
        conexionObtenerEspecialidades.setCadenaSQL("SELECT DISTINCT especialidad\n" +
                                "FROM Medicos\n" +
                                "WHERE especialidad IS NOT NULL AND especialidad != ''\n" +
                                "ORDER BY especialidad;");
        conexionObtenerEspecialidades.setEsSelect(true);
        conexionObtenerEspecialidades.conectar();
        List<String> lista = new ArrayList<>();
        try {
            ResultSet rs = conexionObtenerEspecialidades.getDbresultSet();
            int count = 0;
            while (rs.next()) {
                lista.add(rs.getString("especialidad"));
                count++;
            }
            System.out.println("Especialidades encontradas: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionObtenerEspecialidades.cerrar();
        }

        return lista;
    }

    public void insertar(Medico m) {
        ConexionMySQL conexionInsertar = new ConexionMySQL();
        conexionInsertar.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionInsertar.setNombreTabla("medicos");
        conexionInsertar.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionInsertar.setUsuario("root");
        conexionInsertar.setPass("LALA-luxi1");
        String sql = String.format(
                "INSERT INTO Medicos (nombre, especialidad, correo) VALUES ('%s', '%s', '%s')",
                m.getNombre(), m.getEspecialidad(), m.getCorreo()
        );
        conexionInsertar.setCadenaSQL(sql);
        conexionInsertar.setEsSelect(false);
        conexionInsertar.conectar();
        conexionInsertar.cerrar();
    }

    public void actualizar(Medico m) {
        ConexionMySQL conexionActualizar = new ConexionMySQL();
        conexionActualizar.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionActualizar.setNombreTabla("medicos");
        conexionActualizar.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionActualizar.setUsuario("root");
        conexionActualizar.setPass("LALA-luxi1");
        String sql = String.format(
                "UPDATE Medicos SET nombre='%s', especialidad='%s', correo='%s' WHERE id_medico=%d",
                m.getNombre(), m.getEspecialidad(), m.getCorreo(), m.getIdMedico()
        );
        conexionActualizar.setCadenaSQL(sql);
        conexionActualizar.setEsSelect(false);
        conexionActualizar.conectar();
        conexionActualizar.cerrar();
    }

    public void eliminar(int id) {
        ConexionMySQL conexionEliminar = new ConexionMySQL();
        conexionEliminar.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionEliminar.setNombreTabla("medicos");
        conexionEliminar.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionEliminar.setUsuario("root");
        conexionEliminar.setPass("LALA-luxi1");
        String sql = "DELETE FROM Medicos WHERE id_medico=" + id;
        conexionEliminar.setCadenaSQL(sql);
        conexionEliminar.setEsSelect(false);
        conexionEliminar.conectar();
        conexionEliminar.cerrar();
    }
}
