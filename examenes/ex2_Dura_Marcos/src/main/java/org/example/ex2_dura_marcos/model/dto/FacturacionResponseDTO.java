package org.example.ex2_dura_marcos.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FacturacionResponseDTO {

    private String codigoPedido;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    
    private int totalGastado;

    public FacturacionResponseDTO() {
    }

    public FacturacionResponseDTO(String codigoPedido, LocalDate fecha, int totalGastado) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.totalGastado = totalGastado;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(int totalGastado) {
        this.totalGastado = totalGastado;
    }

}
