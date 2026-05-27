package org.example.ejemplo_examen_curso.model.dto;

import java.time.LocalDate;

public class EstudianteResponseDTO {

    private Integer idEstudiante;
    private String nombreCompleto;
    private String email;
    private LocalDate fechaMatriculacion;

    public EstudianteResponseDTO() {
    }

    public EstudianteResponseDTO(Integer idEstudiante, String nombreCompleto, String email, LocalDate fechaMatriculacion) {
        this.idEstudiante = idEstudiante;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
}
