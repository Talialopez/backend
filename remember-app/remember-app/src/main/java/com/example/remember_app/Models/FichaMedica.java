package com.example.remember_app.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ficha_medica")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private int edad;
    private String genero;
    private String fechaNacimiento;
    private String tipoSangre;
    private String eps;
    private String direccionResidencia;
    private float peso;
    private float estatura;
    private String esquemaVacunacion;
    private String enfermedadesOjos;
    private String lentesPermanentes;
    private String protesis;
    private String alergias;
    private String cirugias;
    private String condicionesEspeciales;
    private String diabetes;
    private String cancer;
    private String hipertension;
    private String enfermedadesCardiovasculares;
    private String otrasEnfermedades;

    @OneToOne
    @JoinColumn(name = "dni_paciente", referencedColumnName = "dni")
    @JsonBackReference
    private Paciente paciente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public String getEsquemaVacunacion() {
        return esquemaVacunacion;
    }

    public void setEsquemaVacunacion(String esquemaVacunacion) {
        this.esquemaVacunacion = esquemaVacunacion;
    }

    public String getLentesPermanentes() {
        return lentesPermanentes;
    }

    public void setLentesPermanentes(String lentesPermanentes) {
        this.lentesPermanentes = lentesPermanentes;
    }

    public String getEnfermedadesOjos() {
        return enfermedadesOjos;
    }

    public void setEnfermedadesOjos(String enfermedadesOjos) {
        this.enfermedadesOjos = enfermedadesOjos;
    }

    public String getProtesis() {
        return protesis;
    }

    public void setProtesis(String protesis) {
        this.protesis = protesis;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCirugias() {
        return cirugias;
    }

    public void setCirugias(String cirugias) {
        this.cirugias = cirugias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getOtrasEnfermedades() {
        return otrasEnfermedades;
    }

    public void setOtrasEnfermedades(String otrasEnfermedades) {
        this.otrasEnfermedades = otrasEnfermedades;
    }

    public String getEnfermedadesCardiovasculares() {
        return enfermedadesCardiovasculares;
    }

    public void setEnfermedadesCardiovasculares(String enfermedadesCardiovasculares) {
        this.enfermedadesCardiovasculares = enfermedadesCardiovasculares;
    }

    public String getHipertension() {
        return hipertension;
    }

    public void setHipertension(String hipertension) {
        this.hipertension = hipertension;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getCondicionesEspeciales() {
        return condicionesEspeciales;
    }

    public void setCondicionesEspeciales(String condicionesEspeciales) {
        this.condicionesEspeciales = condicionesEspeciales;
    }
}
