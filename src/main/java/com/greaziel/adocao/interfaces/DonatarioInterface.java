package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Donatario;

import java.util.List;

public interface DonatarioInterface {

    Donatario criar(Donatario donatario);

    Donatario atualizar(Donatario donatario, int id);

    void deletar(int id);

    Donatario obter(int id);

    List<Donatario> listar();
}
