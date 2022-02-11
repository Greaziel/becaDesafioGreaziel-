package com.greaziel.adocao.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostAdocaoRequest {

    private Integer doador;
    private Integer donatario;
    private Integer pet;

}
