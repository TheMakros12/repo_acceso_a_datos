package com.example.ejemplo_examen_futbol.model.dto;

import com.example.ejemplo_examen_futbol.model.Posicion;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class JugadorRequestDTO {

    @NotBlank(message = "El nombre completo del jugador es obligatorio")
    private String nombreCompleto;

    @NotNull(message = "La posición del jugador es obligatoria")
    private Posicion posicion;

    @NotNull(message = "El salario es obligatorio")
    @DecimalMin(value = "0.01", message = "El salario debe ser mayor a 0")
    private BigDecimal salario;

    @NotNull(message = "El id del equipo es obligatorio")
    private Integer idEquipo;

    public JugadorRequestDTO() {
    }

    public JugadorRequestDTO(String nombreCompleto, Posicion posicion, BigDecimal salario, Integer idEquipo) {
        this.nombreCompleto = nombreCompleto;
        this.posicion = posicion;
        this.salario = salario;
        this.idEquipo = idEquipo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

}