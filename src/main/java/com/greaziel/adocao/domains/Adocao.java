package com.greaziel.adocao.domains;

import javax.persistence.*;

@Entity
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Doador doador;

    @OneToOne
    private Donatario donatario;

    @OneToOne
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
}
