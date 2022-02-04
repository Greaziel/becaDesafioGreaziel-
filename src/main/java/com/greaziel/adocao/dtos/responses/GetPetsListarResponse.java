package com.greaziel.adocao.dtos.responses;

import com.greaziel.adocao.domains.Pets;

import java.util.List;
import java.util.stream.Collectors;

public class GetPetsListarResponse {

    private String nome;
    private String raca;
    private String cor;
    private String proprietario;

    public GetPetsListarResponse(Pets pets) {
        this.setNome(pets.getNome());
        this.setRaca(pets.getRaca());
        this.setCor(pets.getCor());
        this.setProprietario(pets.getProprietario().getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
}
