package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class GetPetsMathResponse {

    private Integer idDonatario;
    private String nome;
    private String raca;
    private String cor;

}
