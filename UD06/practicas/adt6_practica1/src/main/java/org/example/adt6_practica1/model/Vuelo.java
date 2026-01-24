package org.example.adt6_practica1.model;

import jakarta.persistence.*;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String origen;

    @Column
    private String destino;

    @Column
    private float precio;

    @Column
    private int numEscalas;

    @Column
    private String compania;

    public Vuelo() {
    }

    public Vuelo(Integer id, String origen, String destino, float precio, int numEscalas, String compania) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.numEscalas = numEscalas;
        this.compania = compania;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumEscalas() {
        return numEscalas;
    }

    public void setNumEscalas(int numEscalas) {
        this.numEscalas = numEscalas;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
    
}
