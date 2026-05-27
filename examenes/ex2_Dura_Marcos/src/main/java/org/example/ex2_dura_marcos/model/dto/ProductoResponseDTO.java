package org.example.ex2_dura_marcos.model.dto;

import java.time.LocalDate;

public class ProductoResponseDTO {

    private String nombre;
    private int cantidad;
    private int precioUnitario;
    private LocalDate fecha;

    public ProductoResponseDTO() {
    }

    public ProductoResponseDTO(String nombre, int cantidad, int precioUnitario, LocalDate fecha) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
