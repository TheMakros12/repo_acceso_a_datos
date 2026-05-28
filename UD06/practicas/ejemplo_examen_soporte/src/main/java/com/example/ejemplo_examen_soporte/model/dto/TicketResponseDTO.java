package com.example.ejemplo_examen_soporte.model.dto;

import com.example.ejemplo_examen_soporte.model.Estado;
import com.example.ejemplo_examen_soporte.model.Prioridad;

import java.time.LocalDate;

public class TicketResponseDTO {

    private Integer id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private Estado estado;
    private LocalDate fechaCreacion;
    private Integer proyectoId;

    public TicketResponseDTO() {
    }

    public TicketResponseDTO(Integer id, String titulo, String descripcion, Prioridad prioridad,
                             Estado estado, LocalDate fechaCreacion, Integer proyectoId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.proyectoId = proyectoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

}
