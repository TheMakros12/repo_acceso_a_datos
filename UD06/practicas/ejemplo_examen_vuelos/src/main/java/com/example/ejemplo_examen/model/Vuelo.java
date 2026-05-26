package com.example.ejemplo_examen.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVuelo;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoVuelo estado;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pasajero> pasajeros = new ArrayList<>();

    public Vuelo() {
    }

    public Vuelo(Integer idVuelo, String codigo, LocalDate fecha, EstadoVuelo estado, List<Pasajero> pasajeros) {
        this.idVuelo = idVuelo;
        this.codigo = codigo;
        this.fecha = fecha;
        this.estado = estado;
        this.pasajeros = pasajeros;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoVuelo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

}
