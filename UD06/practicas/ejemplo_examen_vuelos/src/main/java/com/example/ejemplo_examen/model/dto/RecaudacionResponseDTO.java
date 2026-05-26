package com.example.ejemplo_examen.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RecaudacionResponseDTO {

    private String codigoVuelo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaVuelo;

    private BigDecimal totalRecaudado;

    public RecaudacionResponseDTO() {
    }

    public RecaudacionResponseDTO(String codigoVuelo, LocalDate fechaVuelo, BigDecimal totalRecaudado) {
        this.codigoVuelo = codigoVuelo;
        this.fechaVuelo = fechaVuelo;
        this.totalRecaudado = totalRecaudado;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public BigDecimal getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(BigDecimal totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

}
