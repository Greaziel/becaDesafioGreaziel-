package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class PatchAdocaoResponse {

    private Integer id;
    private String doador;
    private String donatario;
    private String pet;

}
