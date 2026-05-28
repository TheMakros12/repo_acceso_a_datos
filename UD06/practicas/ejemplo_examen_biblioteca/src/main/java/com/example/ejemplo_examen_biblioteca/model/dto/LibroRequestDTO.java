package com.example.ejemplo_examen_biblioteca.model.dto;

import com.example.ejemplo_examen_biblioteca.model.Estado;
import jakarta.validation.constraints.*;

public class LibroRequestDTO {

    @NotBlank(message = "El título del Libro es obligatorio.")
    private String titulo;

    @NotBlank(message = "El autor del Libro es obligatorio.")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio.")
    @Pattern(regexp = "^[0-9]{10}$|^[0-9]{13}$",
            message = "El ISBN debe tener exactamente 10 o 13 dígitos.")
    private String isbn;

    @Min(value = 1900, message = "El año de Publicación tiene que ser anterior o igual al año actual.")
    @Max(value = 2026, message = "El año de Publicación no puede ser mayor al año actual.")
    private Integer anyoPublicacion;

    @NotBlank(message = "El esto del libro es obligatorio")
    private Estado estado;

    public LibroRequestDTO() {
    }

    public LibroRequestDTO(String titulo, String autor, String isbn, Integer anyoPublicacion, Estado estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anyoPublicacion = anyoPublicacion;
        this.estado = estado;
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

}
