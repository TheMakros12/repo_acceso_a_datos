package com.example.ejemplo_examen.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PasajeroRequestDTO {

    @NotBlank(message = "El nombre del pasajero no puede estar vacío")
    private String nombreCompleto;

    @NotBlank(message = "El número de asiento es obligatorio")
    private String numeroAsiento;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal precioBillete;

    @NotBlank(message = "Debes indicar el código del vuelo")
    private String codigoVuelo;

    public PasajeroRequestDTO() {
    }

    public PasajeroRequestDTO(String nombreCompleto, String numeroAsiento, BigDecimal precioBillete, String codigoVuelo) {
        this.nombreCompleto = nombreCompleto;
        this.numeroAsiento = numeroAsiento;
        this.precioBillete = precioBillete;
        this.codigoVuelo = codigoVuelo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public BigDecimal getPrecioBillete() {
        return precioBillete;
    }

    public void setPrecioBillete(BigDecimal precioBillete) {
        this.precioBillete = precioBillete;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

}
