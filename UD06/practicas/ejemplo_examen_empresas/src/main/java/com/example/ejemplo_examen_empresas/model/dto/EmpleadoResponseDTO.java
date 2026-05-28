package com.example.ejemplo_examen_empresas.model.dto;

import com.example.ejemplo_examen_empresas.model.Puesto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoResponseDTO {

    private Integer id;
    private String nombreCompleto;
    private Puesto puesto;
    private BigDecimal salario;
    private String email;
    private LocalDate fechaContratacion;

    public EmpleadoResponseDTO() {
    }

    public EmpleadoResponseDTO(Integer id, String nombreCompleto, Puesto puesto, BigDecimal salario, String email, LocalDate fechaContratacion) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.salario = salario;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

}
