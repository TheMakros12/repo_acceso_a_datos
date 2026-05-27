package org.example.ex2_dura_marcos.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductoRequestDTO {

    private String nombre;

    @Min(2)
    private int cantidad;

    @Min(5)
    @Max(999)
    private int precioUnitario;

    @NotNull
    private String codigoPedido;

    public ProductoRequestDTO() {
    }

    public ProductoRequestDTO(String nombre, int cantidad, int precioUnitario, String codigoPedido) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.codigoPedido = codigoPedido;
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

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

}
