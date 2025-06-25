package CapaServicios;

import CapaDTO.Box;
import CapaNegocio.BoxNegocio;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WebServiceBoxes {

    BoxNegocio negocio = new BoxNegocio();

    @WebMethod
    public List<Box> WebObtenerTodosBoxes() {
        return negocio.obtenerTodos();
    }

    @WebMethod
    public void WebInsertarBoxes(@WebParam(name = "Box") Box b) {
        negocio.insertar(b);
    }

    @WebMethod
    public void WebActualizarBoxes(@WebParam(name = "Box") Box b) {
        negocio.actualizar(b);
    }

    @WebMethod
    public void WebEliminarBoxes(@WebParam(name = "idBox") int id) {
        negocio.eliminar(id);
    }
}