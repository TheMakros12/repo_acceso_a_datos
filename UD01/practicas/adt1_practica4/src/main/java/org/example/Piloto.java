package org.example;

import java.io.Serializable;

public class Piloto implements Serializable {

    private int num;
    private String nombre;
    private String apellido;
    private String escuderia;
    private int victoria;

    public Piloto() {
    }

    public Piloto(int num, String nombre, String apellido, String escuderia, int victoria) {

        this.num = num;
        this.nombre = nombre;
        this.apellido = apellido;
        this.escuderia = escuderia;
        this.victoria = victoria;

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getVictoria() {
        return victoria;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }

    @Override
    public String toString() {
        return "Piloto {" + num + ", " + nombre + " " + apellido + ", " + escuderia + ", " + victoria + " victorias.}";
    }
}
