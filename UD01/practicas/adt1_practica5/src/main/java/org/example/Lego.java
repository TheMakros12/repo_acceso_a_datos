package org.example;

import java.io.Serializable;

public class Lego implements Serializable {

    private int id;
    private String categoria;
    private String modelo;
    private int piezas;
    private float precio;

    public Lego() {
    }

    public Lego(int id, String categoria, String modelo, int piezas, Float precio) {
        this.id = id;
        this.categoria = categoria;
        this.modelo = modelo;
        this.piezas = piezas;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Lego{" + id + ", " + categoria + ", " + modelo + ", " + piezas + " piezas, " + precio +  "€}";
    }
}
