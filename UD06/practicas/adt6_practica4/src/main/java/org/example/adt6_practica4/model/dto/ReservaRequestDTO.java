package org.example.adt6_practica4.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ReservaRequestDTO {

    @NotNull
    private LocalDate fechaEntrada;

    @NotNull
    private LocalDate fechaSalida;

    @NotNull
    @Min(26)
    @Max(249)
    private Integer precioTotal;

    @NotNull
    @Email
    private String email;

    public ReservaRequestDTO() {
    }

    public ReservaRequestDTO(LocalDate fechaEntrada, LocalDate fechaSalida, Integer precioTotal, String email) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
