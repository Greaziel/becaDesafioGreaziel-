package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class PatchPetsResponse {

    private Integer id;
    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;

}
