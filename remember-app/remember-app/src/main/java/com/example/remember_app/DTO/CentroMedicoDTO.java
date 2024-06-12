package com.example.remember_app.DTO;

public class CentroMedicoDTO {
    private String nombre;

    // Constructor vacío
    public CentroMedicoDTO() {}

    // Constructor con nombre
    public CentroMedicoDTO(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
