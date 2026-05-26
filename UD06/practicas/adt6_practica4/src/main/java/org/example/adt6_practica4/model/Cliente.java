package org.example.adt6_practica4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column
    private String nombre;

    @Column
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String nombre, String email, List<Reserva> reservas) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.email = email;
        this.reservas = reservas;
    }

    public Integer getId_Cliente() {
        return id_cliente;
    }

    public void setId_Clinte(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}
