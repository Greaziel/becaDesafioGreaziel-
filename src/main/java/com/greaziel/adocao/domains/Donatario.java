package com.greaziel.adocao.domains;


import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Donatario extends Pessoa {

    private String tipoPet;
    private String corPet;
    private String racaPet;
    private String portePet;

}
