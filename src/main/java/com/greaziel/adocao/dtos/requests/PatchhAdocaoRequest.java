package com.greaziel.adocao.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchhAdocaoRequest {

    @NotBlank(message = "O campo Doador não pode ser nulo")
    @Size(min = 4, message = "Nome não pode ser menor do que 4")
    private Integer doador;

    @NotBlank(message = "O campo Donatario não pode ser nulo")
    private Integer donatario;

    @NotBlank(message = "O campo Pet não pode ser nulo")
    private Integer pet;
}
