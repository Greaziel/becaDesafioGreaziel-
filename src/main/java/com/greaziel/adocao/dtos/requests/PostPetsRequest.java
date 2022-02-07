package com.greaziel.adocao.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostPetsRequest {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;
    private String tipo;
    private Boolean vacinado;
    private Boolean doado;

    @NotBlank(message = "O campo proprietário não pode ser nulo")
    private Integer proprietario;

}
