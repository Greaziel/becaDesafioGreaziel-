package com.greaziel.adocao.dtos.responses;

import lombok.Data;

@Data
public class PathDoadorResponse {

    private Integer id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;

}
