package org.example;

import java.io.File;

public class GestionArchivos {

    private String rutaTrabajo;
    private String nuevaCarpeta;
    private String nombreArchivo;

    public GestionArchivos() {
        this.rutaTrabajo = File.listRoots()[0].toString();
        this.nuevaCarpeta = "";
        this.nombreArchivo = "";
    }

    public void listarRutaTrabajo(){
        System.out.println("Ruta trabajo -> "+getRutaTrabajo());
    }

    public String getRutaTrabajo() {
        return rutaTrabajo;
    }

    public void setRutaTrabajo(String ruta) {
        this.rutaTrabajo = ruta;
    }

    public String getNuevaCarpeta() {
        return nuevaCarpeta;
    }

    public void setNuevaCarpeta(String nuevaCarpeta) {
        this.nuevaCarpeta = nuevaCarpeta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

}