package com.greaziel.adocao.dtos.responses;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Donatario;

public class GetDonatarioListarResponse {

    private String nome;
    private String cidade;
    private String tipoPet;
    private String corPet;
    private String racaPet;
    private String portePet;

    public GetDonatarioListarResponse(Donatario donatario) {
        this.setNome(donatario.getNome());
        this.setCidade(donatario.getCidade());
        this.setTipoPet(donatario.getTipoPet());
        this.setCorPet(donatario.getCorPet());
        this.setRacaPet(donatario.getRacaPet());
        this.setPortePet(donatario.getPortePet());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(String tipoPet) {
        this.tipoPet = tipoPet;
    }

    public String getCorPet() {
        return corPet;
    }

    public void setCorPet(String corPet) {
        this.corPet = corPet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public void setRacaPet(String racaPet) {
        this.racaPet = racaPet;
    }

    public String getPortePet() {
        return portePet;
    }

    public void setPortePet(String portePet) {
        this.portePet = portePet;
    }
}
