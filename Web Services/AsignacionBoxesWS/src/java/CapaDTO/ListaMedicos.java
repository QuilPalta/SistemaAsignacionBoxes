package CapaDTO;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaMedicos {
    private List<Medico> medicos;

    public ListaMedicos() {}

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
