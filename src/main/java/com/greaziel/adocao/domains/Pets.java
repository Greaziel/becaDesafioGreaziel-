package com.greaziel.adocao.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;
    private String tipo;
    private Boolean vacinado;
    private Boolean doado;

    @OneToOne(cascade = CascadeType.MERGE)
    private Doador proprietario;

}
