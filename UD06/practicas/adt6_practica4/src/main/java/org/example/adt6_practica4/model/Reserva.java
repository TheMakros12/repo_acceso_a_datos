package org.example.adt6_practica4.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;

    @Column
    private LocalDate fechaEntrada;

    @Column
    private LocalDate fechaSalida;

    @Column
    private Integer precioTotal;

    @Column
    private boolean confirmada;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Reserva() {
    }

    public Reserva(Integer id_reserva, LocalDate fechaEntrada, LocalDate fechaSalida, Integer precioTotal, boolean confirmada, Cliente cliente) {
        this.id_reserva = id_reserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
        this.confirmada = confirmada;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id_reserva;
    }

    public void setId(Integer id) {
        this.id_reserva = id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
