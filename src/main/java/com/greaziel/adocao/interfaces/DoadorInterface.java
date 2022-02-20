package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.dtos.requests.PatchDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PatchDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostDoadorResponse;

import java.util.List;

public interface DoadorInterface {

    PostDoadorResponse criar(PostDoadorRequest postDoadorRequest);

    PatchDoadorResponse atualizar(PatchDoadorRequest pathDoadorRequest, Integer id);

    void deletar(Integer id);

    GetDoadorObterResponse obter(Integer id);

    List<GetDoadorListarResponse> listar();
}
