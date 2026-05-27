package com.example.ejemplo_examen_futbol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipo;

    @Column
    private String nombre;

    @Column
    private String ciudad;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL,
                orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo() {
    }

    public Equipo(Integer idEquipo, String nombre, String ciudad, List<Jugador> jugadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.jugadores = jugadores;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}
