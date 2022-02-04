package com.greaziel.adocao.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDoadorObterResponse {

    private Integer id;
    private String nome;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String cidade;
    private String estado;


}
