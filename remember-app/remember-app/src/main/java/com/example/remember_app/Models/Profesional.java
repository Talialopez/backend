package com.example.remember_app.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "profesional")
public class Profesional {

    @Id
    private Long identificacionUnica;

    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;


    @ManyToOne
    @JoinColumn(name = "centro_medico_id")
    @JsonBackReference
    private CentroMedico centroMedico;

    @Column(nullable = false)
    private boolean validated = false;

    @Column(name = "role")
    private String role = "PROFESIONAL";

    // Getters y Setters
    public Long getIdentificacionUnica() {
        return identificacionUnica;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public CentroMedico getCentroMedico() {
        return centroMedico;
    }

    public void setCentroMedico(CentroMedico centroMedico) {
        this.centroMedico = centroMedico;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
