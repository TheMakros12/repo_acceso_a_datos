package com.example.ejemplo_examen_soporte.model.dto;

import com.example.ejemplo_examen_soporte.model.Prioridad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class TicketRequestDTO {

    @NotBlank(message = "El título del ticket es obligatorio.")
    private String titulo;

    @NotBlank(message = "La descripción del ticket es obligatoria.")
    private String descripcion;

    @NotNull(message = "La prioridad del ticket es obligatoria.")
    private Prioridad prioridad;

    @PastOrPresent(message = "La fecha de creación no puede ser una fecha futura.")
    private java.time.LocalDate fechaCreacion;

    public TicketRequestDTO() {
    }

    public TicketRequestDTO(String titulo, String descripcion, Prioridad prioridad, java.time.LocalDate fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public java.time.LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(java.time.LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
