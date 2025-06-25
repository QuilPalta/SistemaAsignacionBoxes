package CapaDTO;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "medico")
@XmlAccessorType(XmlAccessType.FIELD)
public class Medico {
    private int idMedico;
    private String nombre;
    private String especialidad;
    private String correo;

    public int getIdMedico() { return idMedico; }
    public void setIdMedico(int idMedico) { this.idMedico = idMedico; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
