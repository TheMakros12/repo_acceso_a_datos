package org.example.adt6_practica5.model.dto;

public class PiezasPorCategoriaDTO {

    private Long piezasPorCategoria;

    public PiezasPorCategoriaDTO() {
    }

    public PiezasPorCategoriaDTO(Long piezasPorCategoria) {
        this.piezasPorCategoria = piezasPorCategoria;
    }

    public Long getPiezasPorCategoria() {
        return piezasPorCategoria;
    }

    public void setPiezasPorCategoria(Long piezasPorCategoria) {
        this.piezasPorCategoria = piezasPorCategoria;
    }

}
