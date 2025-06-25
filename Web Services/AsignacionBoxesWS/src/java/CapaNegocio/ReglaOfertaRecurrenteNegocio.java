package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.ReglaOfertaRecurrente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReglaOfertaRecurrenteNegocio {

    ConexionMySQL conexion = new ConexionMySQL();

    public void iniciarConexion() {
        conexion.setNombreBaseDatos("jdbc:mysql://localhost/tu_base_datos");
        conexion.setNombreTabla("ReglasOfertaRecurrente");
        conexion.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexion.setUsuario("tu_usuario");
        conexion.setPass("tu_contraseña");
    }

    public List<ReglaOfertaRecurrente> obtenerTodas() {
        iniciarConexion();
        conexion.setCadenaSQL("SELECT * FROM ReglasOfertaRecurrente");
        conexion.setEsSelect(true);
        conexion.conectar();
        List<ReglaOfertaRecurrente> lista = new ArrayList<>();

        try {
            ResultSet rs = conexion.getDbresultSet();
            while (rs.next()) {
                ReglaOfertaRecurrente r = new ReglaOfertaRecurrente();
                r.setIdRegla(rs.getInt("id_regla"));
                r.setIdMedico(rs.getInt("id_medico"));
                r.setDiaSemana(rs.getString("dia_semana"));
                r.setHoraInicio(rs.getString("hora_inicio"));
                r.setHoraFin(rs.getString("hora_fin"));
                r.setFechaInicio(rs.getDate("fecha_inicio"));
                r.setSemanas(rs.getInt("semanas"));
                lista.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return lista;
    }
}