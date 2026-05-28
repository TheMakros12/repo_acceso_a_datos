package com.example.ejemplo_examen_soporte.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTicket;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaICreacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    public Ticket() {
    }

    public Ticket(Integer idTicket, String nombre, String descripcion, Prioridad prioridad, Estado estado, LocalDate fechaICreacion, Proyecto proyecto) {
        this.idTicket = idTicket;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaICreacion = fechaICreacion;
        this.proyecto = proyecto;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
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

    public LocalDate getFechaICreacion() {
        return fechaICreacion;
    }

    public void setFechaICreacion(LocalDate fechaICreacion) {
        this.fechaICreacion = fechaICreacion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}
