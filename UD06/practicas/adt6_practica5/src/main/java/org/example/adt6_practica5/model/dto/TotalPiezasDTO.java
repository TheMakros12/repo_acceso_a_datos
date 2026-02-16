package org.example.adt6_practica5.model.dto;

public class TotalPiezasDTO {

    private Long totalPiezas;

    public TotalPiezasDTO() {
    }

    public TotalPiezasDTO(Long totalPiezas) {
        this.totalPiezas = totalPiezas;
    }

    public Long getTotalPiezas() {
        return totalPiezas;
    }

    public void setTotalPiezas(Long totalPiezas) {
        this.totalPiezas = totalPiezas;
    }

}
