package com.example.ejemplo_examen_biblioteca.model.dto;

import com.example.ejemplo_examen_biblioteca.model.Biblioteca;
import com.example.ejemplo_examen_biblioteca.model.Estado;

public class LibroResponseDTO {

    private Integer idLibro;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anyoPublicacion;
    private Estado estado;
    private Integer idBiblioteca;

    public LibroResponseDTO() {
    }

    public LibroResponseDTO(Integer idLibro, String titulo, String autor, String isbn, Integer anyoPublicacion, Estado estado, Integer idBiblioteca) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anyoPublicacion = anyoPublicacion;
        this.estado = estado;
        this.idBiblioteca = idBiblioteca;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(Integer anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }
    
}
