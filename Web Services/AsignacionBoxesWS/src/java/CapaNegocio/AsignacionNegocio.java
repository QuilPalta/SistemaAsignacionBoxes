package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Asignacion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AsignacionNegocio {

    ConexionMySQL conexion = new ConexionMySQL();

    public void iniciarConexion() {
        conexion.setNombreBaseDatos("jdbc:mysql://localhost/tu_base_datos");
        conexion.setNombreTabla("Asignaciones");
        conexion.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexion.setUsuario("tu_usuario");
        conexion.setPass("tu_contraseña");
    }
    
    public List<Asignacion> obtenerPorBoxYSemana(String nombreBox) {
    iniciarConexion();
    conexion.setCadenaSQL(
        "SELECT a.id_asignacion, a.id_box, a.id_oferta, a.asignado_por, a.fecha_asignacion " +
        "FROM Asignaciones a " +
        "JOIN Boxes b ON a.id_box = b.id_box " +
        "JOIN Ofertas o ON a.id_oferta = o.id_oferta " +
        "WHERE b.nombre_box = '" + nombreBox + "' " +
        "AND WEEK(o.fecha) = WEEK(CURDATE()) AND YEAR(o.fecha) = YEAR(CURDATE())"
    );
    conexion.setEsSelect(true);
    conexion.conectar();

    List<Asignacion> lista = new ArrayList<>();
    try {
        ResultSet rs = conexion.getDbresultSet();
        while (rs.next()) {
            Asignacion a = new Asignacion();
            a.setIdAsignacion(rs.getInt("id_asignacion"));
            a.setIdBox(rs.getInt("id_box"));
            a.setIdOferta(rs.getInt("id_oferta"));
            a.setAsignadoPor(rs.getInt("asignado_por"));
            a.setFechaAsignacion(rs.getTimestamp("fecha_asignacion"));
            lista.add(a);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        conexion.cerrar();
    }

    return lista;
}

    public void asignarOferta(int idBox, int idOferta, int idCoordinador) {
        iniciarConexion();
        String sql = String.format(
            "INSERT INTO Asignaciones (id_box, id_oferta, asignado_por, fecha_asignacion) " +
            "VALUES (%d, %d, %d, NOW())",
            idBox, idOferta, idCoordinador
        );
        conexion.setCadenaSQL(sql);
        conexion.setEsSelect(false);
        conexion.conectar();
        conexion.cerrar();
    }

    public void eliminarAsignacion(int idAsignacion) {
        iniciarConexion();
        String sql = "DELETE FROM Asignaciones WHERE id_asignacion=" + idAsignacion;
        conexion.setCadenaSQL(sql);
        conexion.setEsSelect(false);
        conexion.conectar();
        conexion.cerrar();
    }
}
