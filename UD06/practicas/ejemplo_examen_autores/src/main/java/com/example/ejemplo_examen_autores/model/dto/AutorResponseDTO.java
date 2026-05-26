package com.example.ejemplo_examen_autores.model.dto;

public class AutorResponseDTO {

    private Long id;
    private String nombre;
    private String nacionalidad;

    // Constructores, Getters y Setters
    public AutorResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
