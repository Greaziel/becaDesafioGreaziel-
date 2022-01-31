package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Pets;

import java.util.List;

public interface PetsInterface {

    Pets criar(Pets pets);

    Pets atualizar(Pets pets, Integer id);

    void deletar(Integer id);

    Pets obter(Integer id);

    List<Pets> listar();

    List<Pets> mathPetDonatario(Integer idDonatario);
}
