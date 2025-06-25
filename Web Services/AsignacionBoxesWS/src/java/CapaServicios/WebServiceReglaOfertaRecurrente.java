package CapaServicios;
import CapaDTO.ReglaOfertaRecurrente;
import CapaNegocio.ReglaOfertaRecurrenteNegocio;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WebServiceReglaOfertaRecurrente {

    ReglaOfertaRecurrenteNegocio negocio = new ReglaOfertaRecurrenteNegocio();

    @WebMethod
    public List<ReglaOfertaRecurrente> WebObtenerTodasReglaOfertaRecurrente() {
        return negocio.obtenerTodas();
    }
}
