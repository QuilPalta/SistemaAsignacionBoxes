package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Oferta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OfertaNegocio {
    
    public List<Oferta> obtenerTodas() {
        ConexionMySQL conexionObtenerOferta = new ConexionMySQL();
        conexionObtenerOferta.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionObtenerOferta.setNombreTabla("ofertas");
        conexionObtenerOferta.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionObtenerOferta.setUsuario("root");
        conexionObtenerOferta.setPass("LALA-luxi1");
        conexionObtenerOferta.setCadenaSQL("SELECT * FROM Ofertas");
        conexionObtenerOferta.setEsSelect(true);
        conexionObtenerOferta.conectar();
        List<Oferta> lista = new ArrayList<>();

        try {
            ResultSet rs = conexionObtenerOferta.getDbresultSet();
            while (rs.next()) {
                Oferta o = new Oferta();
                o.setIdOferta(rs.getInt("id_oferta"));
                o.setIdMedico(rs.getInt("id_medico"));
                o.setIdRegla(rs.getObject("id_regla") != null ? rs.getInt("id_regla") : null);
                o.setFecha(rs.getDate("fecha"));
                o.setHoraInicio(rs.getString("hora_inicio"));
                o.setHoraFin(rs.getString("hora_fin"));
                lista.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionObtenerOferta.cerrar();
        }

        return lista;
    }

    public List<Oferta> buscarPorHorario(LocalTime horaInicio, LocalTime horaFin) {
        ConexionMySQL conexionBusquedaHorario = new ConexionMySQL();
        conexionBusquedaHorario.setNombreBaseDatos("jdbc:mysql://localhost:3306/redsalud2025?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        conexionBusquedaHorario.setNombreTabla("ofertas");
        conexionBusquedaHorario.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conexionBusquedaHorario.setUsuario("root");
        conexionBusquedaHorario.setPass("LALA-luxi1");

        String sql = "SELECT * FROM Ofertas WHERE hora_inicio < " + Time.valueOf(horaFin) +" AND hora_fin > " + Time.valueOf(horaInicio);
        conexionBusquedaHorario.setCadenaSQL(sql);
        conexionBusquedaHorario.setEsSelect(true);

        List<Oferta> lista = new ArrayList<>();
        try {
            conexionBusquedaHorario.conectar();
            ResultSet rs = conexionBusquedaHorario.getDbresultSet();

            while (rs.next()) {
                Oferta o = new Oferta();
                o.setIdOferta(rs.getInt("id_oferta"));
                o.setIdMedico(rs.getInt("id_medico"));
                o.setIdRegla(rs.getObject("id_regla") != null ? rs.getInt("id_regla") : null);
                o.setFecha(rs.getDate("fecha"));
                o.setHoraInicio(rs.getString("hora_inicio"));
                o.setHoraFin(rs.getString("hora_fin"));
                o.setCreadaEn(rs.getTimestamp("creada_en").toLocalDateTime());
                lista.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionBusquedaHorario.cerrar();
        }

        return lista;
    }
}
