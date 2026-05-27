package com.example.ejemplo_examen_futbol.model.dto;

import com.example.ejemplo_examen_futbol.model.Posicion;

import java.math.BigDecimal;

public class JugadorResponseDTO {

    private Integer id;

    private String nombreCompleto;

    private Posicion posicion;

    private BigDecimal salario;

    private Integer idEquipo;

    private String nombreEquipo;

    public JugadorResponseDTO() {
    }

    public JugadorResponseDTO(Integer id, String nombreCompleto, Posicion posicion, BigDecimal salario, Integer idEquipo, String nombreEquipo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.posicion = posicion;
        this.salario = salario;
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

}