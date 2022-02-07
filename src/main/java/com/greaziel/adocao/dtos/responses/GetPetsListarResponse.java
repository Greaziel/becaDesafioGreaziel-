package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class GetPetsListarResponse {

    private Integer id;
    private String nome;
    private String raca;
    private String cor;
    private String proprietario;

}
