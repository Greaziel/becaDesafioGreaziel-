package com.greaziel.adocao.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PathPetsRequest {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;
    private String raca;

    @NotBlank(message = "O campo porte não pode ser nulo")
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;
    private String tipo;
    private Boolean vacinado;
    private Boolean doado;

    @NotBlank(message = "O campo proprietario não pode ser nulo")
    private Integer proprietario;

}
