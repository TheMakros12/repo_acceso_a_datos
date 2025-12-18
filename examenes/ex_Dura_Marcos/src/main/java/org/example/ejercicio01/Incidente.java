package org.example.ejercicio01;

import java.io.Serializable;

public class Incidente implements Serializable {

    private String tipo;
    private int gravedad;
    private String fecha;

    public Incidente() {
    }

    public Incidente(String tipo, int gravedad, String fecha) {
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
