package CapaDTO;

public class Coordinador {
    private int idCoordinador;
    private String nombre;
    private String correo;
    private String especialidad;
    private String telefono;

    public int getIdCoordinador() { return idCoordinador; }
    public void setIdCoordinador(int idCoordinador) { this.idCoordinador = idCoordinador; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
