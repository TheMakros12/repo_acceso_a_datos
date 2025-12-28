package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Armas")
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arma")
    private int idArma;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "danyo")
    private int danyo;

    @OneToOne(mappedBy = "arma")
    private Personaje personaje;

    public Arma(int idArma, String nombre, String descripcion, int danyo) {
        super();
        this.idArma = idArma;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.danyo = danyo;
    }

    public Arma(String nombre, String descripcion, int danyo) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.danyo = danyo;
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDanyo() {
        return danyo;
    }

    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
