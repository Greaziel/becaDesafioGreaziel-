package com.greaziel.adocao.dtos.responses;

public class GetPetsMathResponse {

    private Integer idDonatario;
    private String nome;
    private String raca;
    private String cor;

    public Integer getIdDonatario() {
        return idDonatario;
    }

    public void setIdDonatario(Integer idDonatario) {
        this.idDonatario = idDonatario;
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
}
