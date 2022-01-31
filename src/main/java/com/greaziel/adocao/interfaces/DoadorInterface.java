package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Doador;

import java.util.List;

public interface DoadorInterface {

    Doador criar(Doador doador);

    Doador atualizar(Doador doador, Integer id);

    void deletar(Integer id);

    Doador obter(Integer id);

    List<Doador> listar();
}
