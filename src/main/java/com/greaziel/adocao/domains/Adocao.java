package com.greaziel.adocao.domains;

import lombok.Data;

import javax.persistence.*;

@Data
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
    private Pets pet;

}
