package com.example.ejemplo_examen_soporte.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class ProyectoRequestDTO {

    @NotBlank(message = "El nombre del proyecto es obligatorio.")
    private String nombre;

    @NotBlank(message = "La descripción del proyecto es obligatoria.")
    private String descripcion;

    @PastOrPresent(message = "La fecha de inicio no puede ser una fecha futura.")
    private java.time.LocalDate fechaInicio;

    @Positive(message = "El presupuesto debe ser un número positivo mayor a cero.")
    private Double presupuesto;

    public ProyectoRequestDTO() {
    }

    public ProyectoRequestDTO(String nombre, String descripcion, java.time.LocalDate fechaInicio, Double presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.time.LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.time.LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

}
