package com.example.ejemplo_examen_futbol.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EquipoRequestDTO {

    @NotBlank(message = "El nombre del equipo es obligatorio")
    @Size(min = 3, message = "El nombre del equipo debe tener al menos 3 caracteres")
    private String nombre;

    private String ciudad;

    public EquipoRequestDTO() {
    }

    public EquipoRequestDTO(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}