package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Donatario;

import java.util.List;

public interface DonatarioInterface {

    Donatario criar(Donatario donatario);

    Donatario atualizar(Donatario donatario, Integer id);

    void deletar(Integer id);

    Donatario obter(Integer id);

    List<Donatario> listar();
}
