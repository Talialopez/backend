package com.example.remember_app.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "centros_medicos")
public class CentroMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "centroMedico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profesional> profesionales;

    // Constructor vacío
    public CentroMedico() {}

    // Constructor con nombre
    public CentroMedico(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Profesional> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(List<Profesional> profesionales) {
        this.profesionales = profesionales;
    }
}
