package com.example.ejemplo_examen_biblioteca.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class BibliotecaRequestDTO {

    @NotBlank(message = "El nombre de la biblioteca es obligatorio.")
    private String nombre;

    @NotBlank(message = "La ubicación de la biblioteca es obligatoria.")
    private String ubicacion;

    @Min(value = 1900, message = "El año de Apertura tiene que ser anterior o igual al año actual.")
    @Max(value = 2026, message = "El año de Apertura no puede ser mayor al año actual.")
    private Integer anyoApertura;

    public BibliotecaRequestDTO() {
    }

    public BibliotecaRequestDTO(String nombre, String ubicacion, Integer anyoApertura) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.anyoApertura = anyoApertura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getAnyoApertura() {
        return anyoApertura;
    }

    public void setAnyoApertura(Integer anyoApertura) {
        this.anyoApertura = anyoApertura;
    }

}
