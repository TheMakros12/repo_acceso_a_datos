package org.example.adt6_practica4.model.dto;

public class ResumenDTO {

    private Integer confirmadas;
    private Integer noConfirmadas;

    public ResumenDTO() {
    }

    public ResumenDTO(Integer confirmadas, Integer noConfirmadas) {
        this.confirmadas = confirmadas;
        this.noConfirmadas = noConfirmadas;
    }

    public Integer getConfirmadas() {
        return confirmadas;
    }

    public void setConfirmadas(Integer confirmadas) {
        this.confirmadas = confirmadas;
    }

    public Integer getNoConfirmadas() {
        return noConfirmadas;
    }

    public void setNoConfirmadas(Integer noConfirmadas) {
        this.noConfirmadas = noConfirmadas;
    }

}
