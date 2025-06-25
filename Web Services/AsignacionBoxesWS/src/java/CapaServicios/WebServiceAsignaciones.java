package CapaServicios;

import CapaDTO.Asignacion;
import CapaNegocio.AsignacionNegocio;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WebServiceAsignaciones {

    AsignacionNegocio negocio = new AsignacionNegocio();

    @WebMethod
    public List<Asignacion> obtenerPorBoxYSemana(@WebParam(name = "nombreBox") String nombreBox) {
        return negocio.obtenerPorBoxYSemana(nombreBox);
    }

    @WebMethod
    public void WebAsignarOferta(
        @WebParam(name = "idBox") int idBox,
        @WebParam(name = "idOferta") int idOferta,
        @WebParam(name = "idCoordinador") int idCoordinador
    ) {
        negocio.asignarOferta(idBox, idOferta, idCoordinador);
    }

    @WebMethod
    public void WebEliminarAsignacion(@WebParam(name = "idAsignacion") int idAsignacion) {
        negocio.eliminarAsignacion(idAsignacion);
    }
}