package com.greaziel.adocao.model;

public class Adocao {

    private Integer id;
    private Doador doador;
    private Donatario donatario;
    private Animal animal;

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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
