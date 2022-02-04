package com.greaziel.adocao.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDonatarioObterResponse {

    private Integer id;
    private String nome;
    private String cidade;
    private String estado;
    private String tipoPet;
    private String corPet;
    private String racaPet;
    private String portePet;


}
