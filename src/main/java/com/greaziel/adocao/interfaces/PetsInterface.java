package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Pets;

import java.util.List;

public interface PetsInterface {

    Pets criar(Pets pets);

    Pets atualizar(Pets pets, int id);

    void deletar(int id);

    Pets obter(int id);

    List<Pets> listar();

    List<Pets> mathPetDonatario(Integer idDonatario);
}
