package com.example.ejemplo_examen_empresas.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class EmpresaResponseDTO {

    private Integer id;
    private String nombre;
    private String sector;
    private Integer anoFundacion;
    private BigDecimal ingresosAnuales;

    public EmpresaResponseDTO() {
    }

    public EmpresaResponseDTO(Integer id, String nombre, String sector, Integer anoFundacion, BigDecimal ingresosAnuales) {
        this.id = id;
        this.nombre = nombre;
        this.sector = sector;
        this.anoFundacion = anoFundacion;
        this.ingresosAnuales = ingresosAnuales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(Integer anoFundacion) {
        this.anoFundacion = anoFundacion;
    }

    public BigDecimal getIngresosAnuales() {
        return ingresosAnuales;
    }

    public void setIngresosAnuales(BigDecimal ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }

}
