package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Doador;

import java.util.List;

public interface DoadorInterface {

    Doador criar(Doador doador);

    Doador atualizar(Doador doador, int id);

    void deletar( int id);

    Doador obter(int id);

    List<Doador> listar();
}
