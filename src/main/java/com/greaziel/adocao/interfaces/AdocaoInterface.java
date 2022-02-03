package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Adocao;
import com.greaziel.adocao.dtos.requests.PathAdocaoRequest;
import com.greaziel.adocao.dtos.requests.PostAdocaoRequest;
import com.greaziel.adocao.dtos.responses.GetAdocaoListarResponse;
import com.greaziel.adocao.dtos.responses.GetAdocaoOberResponse;
import com.greaziel.adocao.dtos.responses.PathAdocaoResponse;
import com.greaziel.adocao.dtos.responses.PostAdocaoResponse;

import java.util.List;


public interface AdocaoInterface {

    PostAdocaoResponse criar(PostAdocaoRequest postAdocaoRequest);

    PathAdocaoResponse atualizar(PathAdocaoRequest pathAdocaoRequest, Integer id);

    void deletar(Integer id);

    GetAdocaoOberResponse obter(Integer id);

    List<GetAdocaoListarResponse> listar();

}
