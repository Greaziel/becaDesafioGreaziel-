package com.greaziel.adocao.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPetsMathResponse {

    private Integer idDonatario;
    private String nome;
    private String raca;
    private String cor;

}
