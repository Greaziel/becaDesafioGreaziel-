package com.greaziel.adocao.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPetsResponse {

    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;

}
