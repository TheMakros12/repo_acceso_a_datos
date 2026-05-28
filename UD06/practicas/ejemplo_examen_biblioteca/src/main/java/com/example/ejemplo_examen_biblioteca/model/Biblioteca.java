package com.example.ejemplo_examen_biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBiblioteca;

    @Column
    private String nombre;

    @Column
    private String ubicacion;

    @Column
    private Integer anyoApertura;

    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Libro> libros = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(Integer idBiblioteca, String nombre, String ubicacion, Integer anyoApertura, List<Libro> libros) {
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.anyoApertura = anyoApertura;
        this.libros = libros;
    }

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getAnyoApertura() {
        return anyoApertura;
    }

    public void setAnyoApertura(Integer anyoApertura) {
        this.anyoApertura = anyoApertura;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

}
