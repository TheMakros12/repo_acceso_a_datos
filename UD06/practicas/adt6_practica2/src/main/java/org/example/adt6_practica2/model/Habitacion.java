package org.example.adt6_practica2.model;

import jakarta.persistence.*;

@Entity
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer ocupantes;

    @Column
    private Float precio;

    @Column
    private boolean desayuno;

    @Column
    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false, foreignKey = @ForeignKey(name = "fk_habitacion_hotel"))
    private Hotel holel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(Integer ocupantes) {
        this.ocupantes = ocupantes;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Hotel getHolel() {
        return holel;
    }

    public void setHolel(Hotel holel) {
        this.holel = holel;
    }

}
