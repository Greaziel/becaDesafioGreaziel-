package com.greaziel.adocao.domains;

public class Pets {

    private Integer id;
    private Pessoa proprietario;
    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;
    private String tipo;
    private Boolean vacinado;
    private Boolean doado;

    public Pets() {

    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(Boolean vacinado) {
        this.vacinado = vacinado;
    }

    public Boolean isDoado() {
        return doado;
    }

    public void setDoado(Boolean doado) {
        this.doado = doado;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", proprietario=" + proprietario +
                ", nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", porte='" + porte + '\'' +
                ", cor='" + cor + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", tipo='" + tipo + '\'' +
                ", vacinado=" + vacinado +
                ", doado=" + doado +
                '}';
    }
}
