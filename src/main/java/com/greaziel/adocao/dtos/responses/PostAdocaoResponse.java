package com.greaziel.adocao.dtos.responses;

public class PostAdocaoResponse {

   private String nomeDoador;
   private String nomeDonatario;
   private String nomeAnimal;

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getNomeDonatario() {
        return nomeDonatario;
    }

    public void setNomeDonatario(String nomeDonatario) {
        this.nomeDonatario = nomeDonatario;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }
}
