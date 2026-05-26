package com.example.ejemplo_examen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPasajero;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String numeroAsiento;

    @Column(nullable = false)
    private BigDecimal precioBillete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vuelo", nullable = false)
    private Vuelo vuelo;

    public Pasajero() {
    }

    public Pasajero(Integer idPasajero, String nombreCompleto, String numeroAsiento, BigDecimal precioBillete, Vuelo vuelo) {
        this.idPasajero = idPasajero;
        this.nombreCompleto = nombreCompleto;
        this.numeroAsiento = numeroAsiento;
        this.precioBillete = precioBillete;
        this.vuelo = vuelo;
    }

    public Integer getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public BigDecimal getPrecioBillete() {
        return precioBillete;
    }

    public void setPrecioBillete(BigDecimal precioBillete) {
        this.precioBillete = precioBillete;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

}
