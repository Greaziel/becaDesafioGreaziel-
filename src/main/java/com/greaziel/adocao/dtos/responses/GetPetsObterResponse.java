package com.greaziel.adocao.dtos.responses;

public class GetPetsObterResponse {

    private Integer id;
    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;
    private GetDoadorObterResponse getDoadorObterResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public GetDoadorObterResponse getGetDoadorObterResponse() {
        return getDoadorObterResponse;
    }

    public void setGetDoadorObterResponse(GetDoadorObterResponse getDoadorObterResponse) {
        this.getDoadorObterResponse = getDoadorObterResponse;
    }
}
