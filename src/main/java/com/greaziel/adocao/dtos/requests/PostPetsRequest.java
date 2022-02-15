package com.greaziel.adocao.dtos.requests;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostPetsRequest {

    @NotBlank(message = "O campo nome não pode ser nulo")
    @Size(min = 4, message = "Nome não pode ser menor do que 4")
    private String nome;
    private String raca;
    private String porte;
    private String cor;
    private String sexo;
    private Double peso;
    private String tipo;
    private Boolean vacinado;
    private Boolean doado;

    @Min(value = 1)
    private Integer proprietario;

}
