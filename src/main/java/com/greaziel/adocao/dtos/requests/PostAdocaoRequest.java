package com.greaziel.adocao.dtos.requests;

public class PostAdocaoRequest {

    private Integer doador;
    private Integer donatario;
    private Integer animal;

    public Integer getDoador() {
        return doador;
    }

    public void setDoador(Integer doador) {
        this.doador = doador;
    }

    public Integer getDonatario() {
        return donatario;
    }

    public void setDonatario(Integer donatario) {
        this.donatario = donatario;
    }

    public Integer getAnimal() {
        return animal;
    }

    public void setAnimal(Integer animal) {
        this.animal = animal;
    }
}
