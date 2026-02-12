package org.example.adt6_practica4.model.dto;

import java.time.LocalDate;

public class ReservaResponseDTO {

    private String nombreCliente;
    private LocalDate fechaEntrada;
    private Integer precioTotal;

    public ReservaResponseDTO() {
    }

    public ReservaResponseDTO(String nombreCliente, LocalDate fechaEntrada, Integer precioTotal) {
        this.nombreCliente = nombreCliente;
        this.fechaEntrada = fechaEntrada;
        this.precioTotal = precioTotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

}
