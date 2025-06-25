package CapaDTO;

import java.util.Date;

public class ReglaOfertaRecurrente {
    private int idRegla;
    private int idMedico;
    private String diaSemana;
    private String horaInicio;
    private String horaFin;
    private Date fechaInicio;
    private int semanas;

    public int getIdRegla() { return idRegla; }
    public void setIdRegla(int idRegla) { this.idRegla = idRegla; }

    public int getIdMedico() { return idMedico; }
    public void setIdMedico(int idMedico) { this.idMedico = idMedico; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public int getSemanas() { return semanas; }
    public void setSemanas(int semanas) { this.semanas = semanas; }
}

