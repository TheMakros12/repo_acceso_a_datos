package com.example.adt6_practica_examen.model.dto;

public class CocheRequestDTO {

    private String matricula;
    private String modelo;
    private String marca;
    private String color;
    private Double precio;
    private Integer kilometros;

    public CocheRequestDTO() {
    }

    public CocheRequestDTO(String matriucla, String modelo, String marca, String color, Double precio, Integer kilometros) {
        this.matricula = matriucla;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.kilometros = kilometros;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

}
