package com.example.ejemplo_examen.model.dto;

import java.math.BigDecimal;

public class PasajeroResponseDTO {

    private String nombreCompleto;
    private String numeroAsiento;
    private BigDecimal precioBillete;

    public PasajeroResponseDTO() {
    }

    public PasajeroResponseDTO(String nombreCompleto, String numeroAsiento, BigDecimal precioBillete) {
        this.nombreCompleto = nombreCompleto;
        this.numeroAsiento = numeroAsiento;
        this.precioBillete = precioBillete;
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

}
