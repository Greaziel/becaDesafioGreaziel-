package com.greaziel.adocao.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PostAdocaoRequest {

    @NotBlank(message = "O campo doador não pode ser nulo")
    private Integer doador;

    @NotBlank(message = "O campo doador não pode ser nulo")
    private Integer donatario;

    @NotBlank(message = "O campo doador não pode ser nulo")
    private Integer pet;

}
