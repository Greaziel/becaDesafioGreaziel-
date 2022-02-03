package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.dtos.requests.PathDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PathDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostdoadorResponse;

import java.util.List;

public interface DoadorInterface {

    PostdoadorResponse criar(PostDoadorRequest postDoadorRequest);

    PathDoadorResponse atualizar(PathDoadorRequest pathDoadorRequest, Integer id);

    void deletar(Integer id);

    GetDoadorObterResponse obter(Integer id);

    List<GetDoadorListarResponse> listar();
}
