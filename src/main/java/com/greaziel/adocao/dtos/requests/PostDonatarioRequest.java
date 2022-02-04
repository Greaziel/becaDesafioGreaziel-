package com.greaziel.adocao.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PostDonatarioRequest {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;
    private String cep;
    private String logradouro;
    private Integer numero;

    @NotBlank(message = "O campo cidade não pode ser nulo")
    private String cidade;
    private String estado;

    @NotBlank(message = "O campo tipoPet não pode ser nulo")
    private String tipoPet;
    private String corPet;
    private String racaPet;
    private String portePet;

}
