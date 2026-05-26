package com.example.ejemplo_examen_autores.model.dto;

import com.example.ejemplo_examen_autores.model.GeneroLibro;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LibroRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotNull(message = "El género es obligatorio")
    private GeneroLibro genero;

    @NotNull(message = "El año de publicación es obligatorio")
    @Max(value = 2026, message = "El año de publicación no puede ser mayor al actual")
    private Integer anioPublicacion;

    // Constructores, Getters y Setters
    public LibroRequestDTO() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public GeneroLibro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLibro genero) {
        this.genero = genero;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
}
