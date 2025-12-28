package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "asistenciaMedica")
public class AsistenciaMedica {

    @Id
    private int idAsistenciaMedica;

    @Column
    private String breveDescripcion;

    @Column
    private String lugar;

    @Column
    private Float importe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_seguro")
    private Seguro seguro;

    public AsistenciaMedica() {
    }

    public AsistenciaMedica(String breveDescripcion, String lugar, Float importe, Seguro seguro) {
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.importe = importe;
        this.seguro = seguro;
    }

    public AsistenciaMedica(int idAsistenciaMedica, String breveDescripcion, String lugar, Float importe, Seguro seguro) {
        this.idAsistenciaMedica = idAsistenciaMedica;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.importe = importe;
        this.seguro = seguro;
    }

    public int getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    public void setIdAsistenciaMedica(int idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    @Override
    public String toString() {
        return "AsistenciaMedica [ID AsistenciaMedica = " + idAsistenciaMedica + ", Breve Descripcion = " + breveDescripcion
                + ", Lugar = " + lugar + ", Importe = " + importe + ", Seguro = " + seguro.getIdSeguro() + "]";
    }

}
