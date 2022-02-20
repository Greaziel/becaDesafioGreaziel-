package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.dtos.requests.PatchhAdocaoRequest;
import com.greaziel.adocao.dtos.requests.PostAdocaoRequest;
import com.greaziel.adocao.dtos.responses.GetAdocaoListarResponse;
import com.greaziel.adocao.dtos.responses.GetAdocaoOberResponse;
import com.greaziel.adocao.dtos.responses.PatchAdocaoResponse;
import com.greaziel.adocao.dtos.responses.PostAdocaoResponse;

import java.util.List;


public interface AdocaoInterface {

    PostAdocaoResponse criar(PostAdocaoRequest postAdocaoRequest);

    PatchAdocaoResponse atualizar(PatchhAdocaoRequest pathAdocaoRequest, Integer id);

    void deletar(Integer id);

    GetAdocaoOberResponse obter(Integer id);

    List<GetAdocaoListarResponse> listar();

}
