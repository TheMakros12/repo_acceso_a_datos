package com.example.ejemplo_examen_empresas.model.dto;

import com.example.ejemplo_examen_empresas.model.Puesto;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class EmpleadoRequestDTO {

    @NotBlank(message = "El puesto del Empleado es obligatorio")
    private String nombreCompleto;

    @NotNull(message = "El puesto del Empleado es obligatorio")
    private Puesto puesto;

    @Positive(message = "El salario del Empleado tiene que ser positivo")
    private BigDecimal salario;

    @Email
    @NotBlank(message = "El email del Empleado es obligatorio")
    private String email;

    @PastOrPresent(message = "El Fehca de Contratación del Empleado no puede ser futura")
    private LocalDate fechaContratacion;

    public EmpleadoRequestDTO() {
    }

    public EmpleadoRequestDTO(String nombreCompleto, Puesto puesto, BigDecimal salario, String email, LocalDate fechaContratacion) {
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.salario = salario;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
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