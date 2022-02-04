package com.greaziel.adocao.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String cidade;
    private String estado;

}
