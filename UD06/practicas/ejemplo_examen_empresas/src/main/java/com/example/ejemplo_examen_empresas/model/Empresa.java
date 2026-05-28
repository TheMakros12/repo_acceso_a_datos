package com.example.ejemplo_examen_empresas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    @Column
    private String nombre;

    @Column
    private String sector;

    @Column
    private Integer anyoFundacion;

    @Column
    private BigDecimal ingresosAnuales;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Empleado> empleados = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String nombre, String sector, Integer anyoFundacion, BigDecimal ingresosAnuales, List<Empleado> empleados) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.sector = sector;
        this.anyoFundacion = anyoFundacion;
        this.ingresosAnuales = ingresosAnuales;
        this.empleados = empleados;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public Integer getAnyoFundacion() {
        return anyoFundacion;
    }

    public void setAnyoFundacion(Integer anyoFundacion) {
        this.anyoFundacion = anyoFundacion;
    }

    public BigDecimal getIngresosAnuales() {
        return ingresosAnuales;
    }

    public void setIngresosAnuales(BigDecimal ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

}
