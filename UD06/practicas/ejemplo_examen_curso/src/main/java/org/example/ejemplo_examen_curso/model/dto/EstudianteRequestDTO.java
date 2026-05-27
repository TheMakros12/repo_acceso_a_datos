package org.example.ejemplo_examen_curso.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class EstudianteRequestDTO {

    @NotBlank(message = "El nombre del Estudiante es obligatorio.")
    private String nombreCompleto;

    @NotBlank(message = "El email del Estudiante es obligatorio.")
    @Email
    private String email;

    @PastOrPresent(message = "La fehca de matriculación del Estudiante no puede ser futura.")
    private LocalDate fechaMatriculacion;

    public EstudianteRequestDTO() {
    }

    public EstudianteRequestDTO(String nombreCompleto, String email, LocalDate fechaMatriculacion) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.fechaMatriculacion = fechaMatriculacion;
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
