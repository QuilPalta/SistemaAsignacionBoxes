package CapaServicios;

import CapaDTO.ListaMedicos;
import CapaDTO.Medico;
import CapaNegocio.MedicoNegocio;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WebServiceMedicos {

    MedicoNegocio negocio = new MedicoNegocio();

    @WebMethod
    public ListaMedicos WebObtenerTodosMedicos() throws InterruptedException {
        ListaMedicos lista = new ListaMedicos();
        lista.setMedicos(negocio.obtenerTodos());
        return lista;
    }
    
    @WebMethod
    public List<String> WebObtenerEspecialidades() {
        return negocio.obtenerEspecialidades();
    }    

    @WebMethod
    public void WebInsertarMedicos(@WebParam(name = "Medico") Medico m) {
        negocio.insertar(m);
    }

    @WebMethod
    public void WebActualizarMedicos(@WebParam(name = "Medico") Medico m) {
        negocio.actualizar(m);
    }

    @WebMethod
    public void WebEliminarMedicos(@WebParam(name = "idMedico") int id) {
        negocio.eliminar(id);
    }
}