package com.example.ejemplo_examen_autores.model.dto;

import com.example.ejemplo_examen_autores.model.GeneroLibro;

public class LibroResponseDTO {

    private Long id;
    private String titulo;
    private GeneroLibro genero;
    private Integer anioPublicacion;
    
    // Evitamos devolver la Entidad Autor entera para prevenir StackOverflow
    private Long autorId; 
    private String autorNombre; 

    // Constructores, Getters y Setters
    public LibroResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }
}
