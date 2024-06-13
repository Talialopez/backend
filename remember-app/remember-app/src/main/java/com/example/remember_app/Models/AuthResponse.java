package com.example.remember_app.Models;

public class AuthResponse {
    private String token;
    private boolean validated;
    private String nombre;

    // Constructor
    public AuthResponse(String token, boolean validated, String nombre) {
        this.token = token;
        this.validated = validated;
        this.nombre = nombre;
    }

    // Getters y setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

