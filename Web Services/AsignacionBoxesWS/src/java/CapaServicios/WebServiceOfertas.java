package CapaServicios;

import CapaDTO.Oferta;
import CapaNegocio.OfertaNegocio;
import java.time.LocalTime;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WebServiceOfertas {

    OfertaNegocio negocio = new OfertaNegocio();

    @WebMethod
    public List<Oferta> WebObtenerTodasOfertas() {
        return negocio.obtenerTodas();
    }
    @WebMethod
    public List<Oferta> WebBuscarPorHorario(@WebParam(name = "horaInicio") LocalTime horaInicio,@WebParam(name = "horaFinal") LocalTime horaFinal) {
        return negocio.buscarPorHorario(horaInicio, horaFinal);
    }
}