package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.dtos.requests.PatchPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.*;

import java.util.List;

public interface PetsInterface {

    PostPetsResponse criar(PostPetsRequest postPetsRequest);

    PatchPetsResponse atualizar(PatchPetsRequest pathPetsRequest, Integer id);

    void deletar(Integer id);

    GetPetsObterResponse obter(Integer id);

    List<GetPetsListarResponse> listar();

//    List<GetPetsMathResponse> mathPetDonatario(Integer idDonatario);
}
