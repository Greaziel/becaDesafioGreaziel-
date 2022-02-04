package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.dtos.requests.PathDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.GetDonatarioListarResponse;
import com.greaziel.adocao.dtos.responses.GetDonatarioObterResponse;
import com.greaziel.adocao.dtos.responses.PathDonatarioResponse;
import com.greaziel.adocao.dtos.responses.PostDonatarioResponse;

import java.util.List;

public interface DonatarioInterface {

    PostDonatarioResponse criar(PostDonatarioRequest postDonatarioRequest);

    PathDonatarioResponse atualizar(PathDonatarioRequest pathDonatarioRequest, Integer id);

    void deletar(Integer id);

    GetDonatarioObterResponse obter(Integer id);

    List<GetDonatarioListarResponse> listar();
}
