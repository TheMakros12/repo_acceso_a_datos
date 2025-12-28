package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private int idPersonaje;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "vida")
    private int vida;

    @Column(name = "puntos")
    private int puntos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "personaje_arma",
            joinColumns = {@JoinColumn(name = "id_personaje")},
            inverseJoinColumns = {@JoinColumn(name = "id_arma")})
    private List<Arma> armas = new ArrayList<>();

    public Personaje() {
    }

    public Personaje(String nombre, int vida, int puntos) {
        this.nombre = nombre;
        this.vida = vida;
        this.puntos = puntos;
    }

    public Personaje(int idPersonaje, String nombre, int vida, int puntos) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.vida = vida;
        this.puntos = puntos;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

}
