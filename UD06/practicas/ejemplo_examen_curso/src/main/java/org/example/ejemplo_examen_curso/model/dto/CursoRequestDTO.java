package org.example.ejemplo_examen_curso.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CursoRequestDTO {

    @NotBlank(message = "El nombre del Curso es obligatorio y debe de ser único.")
    private String nombre;

    @NotBlank(message = "El nombre del profesor en el  Curso es obligatorio.")
    private String profesor;

    @Positive(message = "El número de créditos debe de ser positivo.")
    private Integer creditos;

    public CursoRequestDTO() {
    }

    public CursoRequestDTO(String nombre, String profesor, Integer creditos) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

}
