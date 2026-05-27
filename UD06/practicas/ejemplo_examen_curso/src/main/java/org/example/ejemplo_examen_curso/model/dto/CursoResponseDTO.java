package org.example.ejemplo_examen_curso.model.dto;

public class CursoResponseDTO {

    private Integer idCurso;
    private String nombre;
    private String profesorAsignado;
    private Integer creditos;

    public CursoResponseDTO() {
    }

    public CursoResponseDTO(Integer idCurso, String nombre, String profesorAsignado, Integer creditos) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.profesorAsignado = profesorAsignado;
        this.creditos = creditos;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesorAsignado() {
        return profesorAsignado;
    }

    public void setProfesorAsignado(String profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

}
