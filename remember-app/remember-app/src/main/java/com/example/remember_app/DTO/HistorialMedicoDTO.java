package com.example.remember_app.DTO;

public class HistorialMedicoDTO {

    private String dniPaciente;
    private String fecha;
    private String motivoConsulta;

    public HistorialMedicoDTO() {
    }

    public HistorialMedicoDTO(String dniPaciente, String fecha, String motivoConsulta) {
        this.dniPaciente = dniPaciente;
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
}
