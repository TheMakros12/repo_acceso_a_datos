package org.example.ejemplo_examen_curso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column
    private String nombre;

    @Column
    private String profesor;

    @Column
    private Integer creditos;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, String profesor, Integer creditos, List<Estudiante> estudiantes) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.profesor = profesor;
        this.creditos = creditos;
        this.estudiantes = estudiantes;
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

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
