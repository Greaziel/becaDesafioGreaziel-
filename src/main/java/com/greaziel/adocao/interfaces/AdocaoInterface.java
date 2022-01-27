package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Adocao;

import java.util.List;

public interface AdocaoInterface {

    Adocao criar(Adocao adocao);

    Adocao atualizar(Adocao adocao, int id);

    void deletar(int id);

    Adocao obter(int id);

    List<Adocao> listar();

}
