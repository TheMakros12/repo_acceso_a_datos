package com.example.ejemplo_examen_futbol.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreCompleto;

    @Column
    @Enumerated(EnumType.STRING)
    private Posicion posicion;

    @Column
    private BigDecimal salario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(Integer id, String nombreCompleto, Posicion posicion, BigDecimal salario, Equipo equipo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.posicion = posicion;
        this.salario = salario;
        this.equipo = equipo;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}
