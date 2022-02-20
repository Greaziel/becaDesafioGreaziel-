package com.greaziel.adocao.dtos.requests;

import lombok.Data;

@Data
public class PatchhAdocaoRequest {

    private Integer doador;
    private Integer donatario;
    private Integer pet;
}
