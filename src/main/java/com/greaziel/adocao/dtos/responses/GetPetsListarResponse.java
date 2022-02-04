package com.greaziel.adocao.dtos.responses;

import com.greaziel.adocao.domains.Pets;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPetsListarResponse {

    private String nome;
    private String raca;
    private String cor;
    private String proprietario;

}
