package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Adocao;

import java.util.List;


public interface AdocaoInterface {

    Adocao criar(Adocao adocao);

    Adocao atualizar(Adocao adocao, Integer id);

    void deletar(Integer id);

    Adocao obter(Integer id);

    List<Adocao> listar();

}
