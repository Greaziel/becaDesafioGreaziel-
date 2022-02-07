package com.greaziel.adocao.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PathAdocaoRequest {

    @NotBlank(message = "O campo Doador não pode ser nulo")
    private Integer doador;

    @NotBlank(message = "O campo Donatario não pode ser nulo")
    private Integer donatario;

    @NotBlank(message = "O campo Pet não pode ser nulo")
    private Integer pet;
}
