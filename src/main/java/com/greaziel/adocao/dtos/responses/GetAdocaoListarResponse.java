package com.greaziel.adocao.dtos.responses;

public class GetAdocaoListarResponse {

    private String doador;
    private String animal;
    private String donatario;

    public String getDoador() {
        return doador;
    }

    public void setDoador(String doador) {
        this.doador = doador;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDonatario() {
        return donatario;
    }

    public void setDonatario(String donatario) {
        this.donatario = donatario;
    }
}
