package com.example.ejemplo_examen_empresas.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class EmpresaRequestDTO {

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    private String nombre;

    @NotBlank(message = "El sector de la empresa es obligatorio")
    private String sector;

    @PastOrPresent(message = "El año de fundación debe ser mayor o igual a 1900")
    private Integer anoFundacion;

    @Positive(message = "Los ingresos anuales deben ser un número positivo mayor a cero")
    private BigDecimal ingresosAnuales;

    public EmpresaRequestDTO() {
    }

    public EmpresaRequestDTO(String nombre, String sector, Integer anoFundacion, BigDecimal ingresosAnuales) {
        this.nombre = nombre;
        this.sector = sector;
        this.anoFundacion = anoFundacion;
        this.ingresosAnuales = ingresosAnuales;
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
