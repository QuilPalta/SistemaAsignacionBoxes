package CapaServicios;

import CapaDTO.Coordinador;
import CapaNegocio.CoordinadorNegocio;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WebServiceCoordinador {

    CoordinadorNegocio negocio = new CoordinadorNegocio();

    @WebMethod
    public List<Coordinador> WebObtenerTodosCoordinador() {
        return negocio.obtenerTodos();
    }
}

