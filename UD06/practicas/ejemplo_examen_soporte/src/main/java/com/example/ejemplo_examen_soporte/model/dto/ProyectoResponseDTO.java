package com.example.ejemplo_examen_soporte.model.dto;

import java.time.LocalDate;
import java.util.List;

public class ProyectoResponseDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private Double presupuesto;
    private List<TicketResponseDTO> tickets;

    public ProyectoResponseDTO() {
    }

    public ProyectoResponseDTO(Integer id, String nombre, String descripcion, LocalDate fechaInicio,
                               Double presupuesto, List<TicketResponseDTO> tickets) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.presupuesto = presupuesto;
        this.tickets = tickets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<TicketResponseDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketResponseDTO> tickets) {
        this.tickets = tickets;
    }

}
