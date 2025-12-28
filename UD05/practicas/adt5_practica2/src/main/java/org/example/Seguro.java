package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private String apellido1;

    @Column
    private String apellido2;

    @Column
    private int edad;

    @Column
    private int numHijos;

    @Column
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL)
    private List<AsistenciaMedica> asistenciasMedicas;

    public Seguro() {
    }

    public Seguro(String nif, String nombre, String ape1, String ape2, int edad, int numHijos, LocalDate fechaCreacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = ape1;
        this.apellido2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
    }

    public Seguro(int idSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos, LocalDate fechaCreacion) {
        this.idSeguro = idSeguro;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = ape1;
        this.apellido2 = ape2;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    public List<AsistenciaMedica> getAsistenciasMedicas() {
        return asistenciasMedicas;
    }

    public void setAsistenciasMedicas(List<AsistenciaMedica> asistenciasMedicas) {
        this.asistenciasMedicas = asistenciasMedicas;
    }

    @Override
    public String toString() {
        return "Seguro [ID Seguro = " + idSeguro + ", NIF =" + nif + ", Nombre =" + nombre + ", Apellido1 = " + apellido1 + ", Apellido2= "
                + apellido2 + ", Edad = " + edad + ", Num. Hijos =" + numHijos + ", FechaCreacion = " + fechaCreacion + "]";
    }

}
