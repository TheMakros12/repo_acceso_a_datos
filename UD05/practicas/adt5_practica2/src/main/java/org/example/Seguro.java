package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seguro")
public class Seguro {

    @Id
    private int idSeguro;

    @Column
    private String nif;

    @Column
    private String nombre;

    @Column
    private String ape1;

    @Column
    private String ape2;

    @Column
    private int edad;

    @Column
    private int numHijos;

    @Column
    private LocalDate fechaCreacion;

    public Seguro() {
    }

    public Seguro(String nif, String nombre, String ape1, String ape2, int edad, int numHijos, LocalDate fechaCreacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
    }

    public Seguro(int idSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos, LocalDate fechaCreacion) {
        this.idSeguro = idSeguro;
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /*public List<AsistenciaMedica> getAsistenciasMedicas() {
        return asistenciasMedicas;
    }

    public void setAsistenciasMedicas(List<AsistenciaMedica> asistenciasMedicas) {
        this.asistenciasMedicas = asistenciasMedicas;
    }*/

    @Override
    public String toString() {
        return "Seguro [ID Seguro = " + idSeguro + ", NIF =" + nif + ", Nombre =" + nombre + ", Apellido1 = " + ape1 + ", Apellido2= "
                + ape2 + ", Edad = " + edad + ", Num. Hijos =" + numHijos + ", FechaCreacion = " + fechaCreacion + "]";
    }

}
