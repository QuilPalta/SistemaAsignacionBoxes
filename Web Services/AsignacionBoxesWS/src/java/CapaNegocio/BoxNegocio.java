package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Box;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoxNegocio {

    ConexionMySQL conexion = new ConexionMySQL();

    public void iniciarConexion() {
        conexion.setNombreBaseDatos("jdbc:mysql://localhost/tu_base_datos");
        conexion.setNombreTabla("Boxes");
        conexion.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexion.setUsuario("tu_usuario");
        conexion.setPass("tu_contraseña");
    }

    public List<Box> obtenerTodos() {
        iniciarConexion();
        conexion.setCadenaSQL("SELECT * FROM Boxes");
        conexion.setEsSelect(true);
        conexion.conectar();
        List<Box> lista = new ArrayList<>();

        try {
            ResultSet rs = conexion.getDbresultSet();
            while (rs.next()) {
                Box b = new Box();
                b.setIdBox(rs.getInt("id_box"));
                b.setNombreBox(rs.getString("nombre_box"));
                b.setPiso(rs.getInt("piso"));
                b.setTipo(rs.getString("tipo"));
                b.setEstado(rs.getString("estado"));
                lista.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return lista;
    }
    
    public void insertar(Box b) {
        iniciarConexion();
        String sql = String.format(
            "INSERT INTO Boxes (nombre_box, piso, tipo, estado) VALUES ('%s', %d, '%s', '%s')",
            b.getNombreBox(), b.getPiso(), b.getTipo(), b.getEstado()
        );
        conexion.setCadenaSQL(sql);
        conexion.setEsSelect(false);
        conexion.conectar();
        conexion.cerrar();
    }

    public void actualizar(Box b) {
        iniciarConexion();
        String sql = String.format(
            "UPDATE Boxes SET nombre_box='%s', piso=%d, tipo='%s', estado='%s' WHERE id_box=%d",
            b.getNombreBox(), b.getPiso(), b.getTipo(), b.getEstado(), b.getIdBox()
        );
        conexion.setCadenaSQL(sql);
        conexion.setEsSelect(false);
        conexion.conectar();
        conexion.cerrar();
    }

    public void eliminar(int id) {
        iniciarConexion();
        String sql = "DELETE FROM Boxes WHERE id_box=" + id;
        conexion.setCadenaSQL(sql);
        conexion.setEsSelect(false);
        conexion.conectar();
        conexion.cerrar();
    }
}
