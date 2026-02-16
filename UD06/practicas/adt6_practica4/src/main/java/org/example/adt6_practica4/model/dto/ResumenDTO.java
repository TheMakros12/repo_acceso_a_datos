package org.example.adt6_practica4.model.dto;

public class ResumenDTO {

    private long confirmadas;
    private long noConfirmadas;

    public ResumenDTO() {
    }

    public ResumenDTO(long confirmadas, long noConfirmadas) {
        this.confirmadas = confirmadas;
        this.noConfirmadas = noConfirmadas;
    }

    public long getConfirmadas() {
        return confirmadas;
    }

    public void setConfirmadas(long confirmadas) {
        this.confirmadas = confirmadas;
    }

    public long getNoConfirmadas() {
        return noConfirmadas;
    }

    public void setNoConfirmadas(long noConfirmadas) {
        this.noConfirmadas = noConfirmadas;
    }

}
