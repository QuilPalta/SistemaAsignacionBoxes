package CapaDTO;

import java.util.Date;

public class Asignacion {
    private int idAsignacion;
    private int idBox;
    private int idOferta;
    private int asignadoPor;
    private Date fechaAsignacion;

    public int getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(int idAsignacion) { this.idAsignacion = idAsignacion; }

    public int getIdBox() { return idBox; }
    public void setIdBox(int idBox) { this.idBox = idBox; }

    public int getIdOferta() { return idOferta; }
    public void setIdOferta(int idOferta) { this.idOferta = idOferta; }

    public int getAsignadoPor() { return asignadoPor; }
    public void setAsignadoPor(int asignadoPor) { this.asignadoPor = asignadoPor; }

    public Date getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(Date fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}
