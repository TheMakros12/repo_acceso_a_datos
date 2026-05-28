package com.example.ejemplo_examen_biblioteca.model.dto;

import java.util.List;

public class BibliotecaResponseDTO {

    private Integer idBiblioteca;
    private String nombre;
    private String ubicacion;
    private Integer anyoApertura;
    private List<LibroResponseDTO> libros;

    public BibliotecaResponseDTO() {
    }

    public BibliotecaResponseDTO(Integer idBiblioteca, String nombre, String ubicacion, Integer anyoApertura, List<LibroResponseDTO> libros) {
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

    public List<LibroResponseDTO> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroResponseDTO> libros) {
        this.libros = libros;
    }
    
}
