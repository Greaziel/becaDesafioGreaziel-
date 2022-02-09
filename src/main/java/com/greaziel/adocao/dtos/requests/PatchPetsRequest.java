package com.greaziel.adocao.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchPetsRequest {

    @NotBlank(message = "O campo nome não pode ser nulo")
    @Size(min = 4, message = "Nome não pode ser menor do que 4")
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

    @NotBlank(message = "O campo proprietário não pode ser nulo")
    private Integer proprietario;

}
