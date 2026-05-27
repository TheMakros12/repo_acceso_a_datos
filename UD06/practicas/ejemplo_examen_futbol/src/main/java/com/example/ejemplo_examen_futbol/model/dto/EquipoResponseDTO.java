package com.example.ejemplo_examen_futbol.model.dto;

import com.example.ejemplo_examen_futbol.model.dto.JugadorResponseDTO;

import java.util.List;

public class EquipoResponseDTO {

    private Integer idEquipo;
    private String nombre;
    private String ciudad;

    // Para evitar recursividad infinita usamos DTOs
    private List<JugadorResponseDTO> jugadores;

    public EquipoResponseDTO() {
    }

    public EquipoResponseDTO(Integer idEquipo, String nombre, String ciudad, List<JugadorResponseDTO> jugadores) {
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

    public List<JugadorResponseDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorResponseDTO> jugadores) {
        this.jugadores = jugadores;
    }

}