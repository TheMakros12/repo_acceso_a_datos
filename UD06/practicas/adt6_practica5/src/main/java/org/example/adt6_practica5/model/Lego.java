package org.example.adt6_practica5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "legos")
public class Lego {

    @Id
    private Integer id;

    @Column
    private String modelo;

    @Column
    private String categoria;

    @Column
    private Integer piezas;

    @Column
    private float precio;


    public Lego() {
    }

    public Lego(Integer id, String modelo, String categoria, Integer piezas, float precio) {
        this.id = id;
        this.modelo = modelo;
        this.categoria = categoria;
        this.piezas = piezas;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPiezas() {
        return piezas;
    }

    public void setPiezas(Integer piezas) {
        this.piezas = piezas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
