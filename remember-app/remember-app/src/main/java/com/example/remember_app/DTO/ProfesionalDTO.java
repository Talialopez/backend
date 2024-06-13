package com.example.remember_app.DTO;

public class ProfesionalDTO {
    private Long identificacionUnica;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private Long centroMedicoId;
    private boolean validated;

    // Getters y setters


    public Long getIdentificacionUnica() {
        return identificacionUnica;
    }

    public void setIdentificacionUnica(Long identificacionUnica) {
        this.identificacionUnica = identificacionUnica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getCentroMedicoId() {
        return centroMedicoId;
    }

    public void setCentroMedicoId(Long centroMedicoId) {
        this.centroMedicoId = centroMedicoId;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
