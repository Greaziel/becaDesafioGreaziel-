package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class GetAdocaoListarResponse {

    private Integer id;
    private String doador;
    private String pet;
    private String donatario;

}
