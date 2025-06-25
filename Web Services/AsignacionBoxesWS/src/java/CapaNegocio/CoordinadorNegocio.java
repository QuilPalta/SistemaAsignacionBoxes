package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Coordinador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoordinadorNegocio {

    ConexionMySQL conexion = new ConexionMySQL();

    public void iniciarConexion() {
        conexion.setNombreBaseDatos("jdbc:mysql://localhost/tu_base_datos");
        conexion.setNombreTabla("Coordinadores");
        conexion.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexion.setUsuario("tu_usuario");
        conexion.setPass("tu_contraseña");
    }

    public List<Coordinador> obtenerTodos() {
        iniciarConexion();
        conexion.setCadenaSQL("SELECT * FROM Coordinadores");
        conexion.setEsSelect(true);
        conexion.conectar();
        List<Coordinador> lista = new ArrayList<>();

        try {
            ResultSet rs = conexion.getDbresultSet();
            while (rs.next()) {
                Coordinador c = new Coordinador();
                c.setIdCoordinador(rs.getInt("id_coordinador"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setEspecialidad(rs.getString("especialidad"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return lista;
    }
}

