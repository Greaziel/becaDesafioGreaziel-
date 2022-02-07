package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class GetAdocaoOberResponse {

    private Integer id;
    private String nomeDoador;
    private String cidadeDoador;
    private String nomeDonatario;
    private String cidadeDonatario;
    private String nomePet;
    private String RacaPet;

}
