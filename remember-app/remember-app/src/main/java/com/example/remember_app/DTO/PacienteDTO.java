package com.example.remember_app.DTO;

public class PacienteDTO {
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private Long identificacionUnica; // ID del profesional

    // Getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Long getIdentificacionUnica() {
        return identificacionUnica;
    }

    public void setIdentificacionUnica(Long identificacionUnica) {
        this.identificacionUnica = identificacionUnica;
    }
}
