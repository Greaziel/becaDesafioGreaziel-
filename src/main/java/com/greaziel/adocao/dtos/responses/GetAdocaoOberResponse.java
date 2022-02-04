package com.greaziel.adocao.dtos.responses;

public class GetAdocaoOberResponse {

    private Integer id;
    private String nomeDoador;
    private String cidadeDoador;
    private String nomeDonatario;
    private String cidadeDonatario;
    private String nomePet;
    private String RacaPet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getCidadeDoador() {
        return cidadeDoador;
    }

    public void setCidadeDoador(String cidadeDoador) {
        this.cidadeDoador = cidadeDoador;
    }

    public String getNomeDonatario() {
        return nomeDonatario;
    }

    public void setNomeDonatario(String nomeDonatario) {
        this.nomeDonatario = nomeDonatario;
    }

    public String getCidadeDonatario() {
        return cidadeDonatario;
    }

    public void setCidadeDonatario(String cidadeDonatario) {
        this.cidadeDonatario = cidadeDonatario;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getRacaPet() {
        return RacaPet;
    }

    public void setRacaPet(String racaPet) {
        RacaPet = racaPet;
    }
}
