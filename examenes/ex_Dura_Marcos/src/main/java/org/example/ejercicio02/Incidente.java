package org.example.ejercicio02;

public class Incidente {

    private String id;
    private String tipo;
    private String zona;
    private double co2Emitido;
    private String fecha;

    public Incidente() {
    }

    public Incidente(String id, String tipo, String zona, double co2Emitido, String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.zona = zona;
        this.co2Emitido = co2Emitido;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getCo2Emitido() {
        return co2Emitido;
    }

    public void setCo2Emitido(double co2Emitido) {
        this.co2Emitido = co2Emitido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
