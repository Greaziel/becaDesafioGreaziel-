package com.greaziel.adocao.interfaces;

import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PathPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.*;

import java.util.List;

public interface PetsInterface {

    PostPetsResponse criar(PostPetsRequest postPetsRequest);

    PathPetsResponse atualizar(PathPetsRequest pathPetsRequest, Integer id);

    void deletar(Integer id);

    GetPetsObterResponse obter(Integer id);

    List<GetPetsListarResponse> listar();

//    List<GetPetsMathResponse> mathPetDonatario(Integer idDonatario);
}
