package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.dtos.requests.PatchDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.GetDonatarioListarResponse;
import com.greaziel.adocao.dtos.responses.GetDonatarioObterResponse;
import com.greaziel.adocao.dtos.responses.PatchDonatarioResponse;
import com.greaziel.adocao.dtos.responses.PostDonatarioResponse;

import java.util.List;

public interface DonatarioInterface {

    PostDonatarioResponse criar(PostDonatarioRequest postDonatarioRequest);

    PatchDonatarioResponse atualizar(PatchDonatarioRequest pathDonatarioRequest, Integer id);

    void deletar(Integer id);

    GetDonatarioObterResponse obter(Integer id);

    List<GetDonatarioListarResponse> listar();
}
