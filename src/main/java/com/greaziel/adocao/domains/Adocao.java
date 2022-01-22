package com.greaziel.adocao.domains;

public class Adocao {

    private Integer id;
    private Doador doador;
    private Donatario donatario;
    private Pets animal;

    public Adocao() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Donatario getDonatario() {
        return donatario;
    }

    public void setDonatario(Donatario donatario) {
        this.donatario = donatario;
    }

    public Pets getAnimal() {
        return animal;
    }

    public void setAnimal(Pets animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Adocao{" +
                "id=" + id +
                ", doador=" + doador +
                ", donatario=" + donatario +
                ", animal=" + animal +
                '}';
    }
}
