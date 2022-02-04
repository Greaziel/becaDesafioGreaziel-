package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Adocao;
import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PathAdocaoRequest;
import com.greaziel.adocao.dtos.requests.PostAdocaoRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.AdocaoInterface;
import com.greaziel.adocao.repositorys.AdocaoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdocaoService implements AdocaoInterface {

    private final DoadorSevice doadorSevice;

    private final DonatarioService donatarioService;

    private final PetsService petsService;

    private final AdocaoRepository adocaoRepository;

    private final ModelMapper modelMapper;


    public PostAdocaoResponse criar(PostAdocaoRequest postAdocaoRequest) {

        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(postAdocaoRequest.getDoador());
        Doador doador = this.getDoadorObterResponse(getDoadorObterResponse);

        GetDonatarioObterResponse getDonatarioObterResponse = donatarioService.obter(postAdocaoRequest.getDonatario());
        Donatario donatario = this.getDonatarioObterResponse(getDonatarioObterResponse);

        GetPetsObterResponse getPetsObterResponse = petsService.obter(postAdocaoRequest.getPet());
        Pets pets = this.getPetsObterResponse(getPetsObterResponse);

        Adocao adocaoCriada = new Adocao();
        adocaoCriada.setDoador(doador);
        adocaoCriada.setDonatario(donatario);
        adocaoCriada.setPet(pets);
        adocaoRepository.save(adocaoCriada);

        PostAdocaoResponse postAdocaoResponse = this.postAdocaoResponse(adocaoCriada);

        return postAdocaoResponse;

    }

    public PathAdocaoResponse atualizar(PathAdocaoRequest pathAdocaoRequest, Integer id) {

        Adocao adocaoAtualizada = adocaoRepository.getById(id);
        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(pathAdocaoRequest.getDoador());
        Doador doador = this.getDoadorObterResponse(getDoadorObterResponse);

        GetDonatarioObterResponse getDonatarioObterResponse = donatarioService.obter(pathAdocaoRequest.getDonatario());
        Donatario donatario = this.getDonatarioObterResponse(getDonatarioObterResponse);

        GetPetsObterResponse getPetsObterResponse = petsService.obter(pathAdocaoRequest.getPet());
        Pets pets = this.getPetsObterResponse(getPetsObterResponse);

        adocaoAtualizada.setId(id);
        adocaoAtualizada.setDoador(doador);
        adocaoAtualizada.setDonatario(donatario);
        adocaoAtualizada.setPet(pets);
        adocaoRepository.save(adocaoAtualizada);

        PathAdocaoResponse pathAdocaoResponse = this.pathAdocaoResponse(adocaoAtualizada);

        return pathAdocaoResponse;

    }

   public void deletar(Integer id) {
        adocaoRepository.deleteById(id);
    }

    public GetAdocaoOberResponse obter(Integer id) {
        Adocao adocaoObter = adocaoRepository.findById(id).get();

        GetAdocaoOberResponse adocaoOberResponse = this.getAdocaoOberResponse(adocaoObter);

        return adocaoOberResponse;
    }

    public List<GetAdocaoListarResponse> listar() {

        List<Adocao> listaAdocao = adocaoRepository.findAll();
        List<GetAdocaoListarResponse> getAdocaoListarResponseList = new ArrayList<>();

        listaAdocao.stream().forEach(adocao ->
                getAdocaoListarResponseList.add(this.getAdocaoListarResponse(adocao)));

        return getAdocaoListarResponseList;

    }

    private Doador getDoadorObterResponse(GetDoadorObterResponse getDoadorObterResponse){

        return modelMapper.map(getDoadorObterResponse, Doador.class);

    }

    private Donatario getDonatarioObterResponse(GetDonatarioObterResponse getDonatarioObterResponse){

        return modelMapper.map(getDonatarioObterResponse, Donatario.class);

    }

    private Pets getPetsObterResponse(GetPetsObterResponse getPetsObterResponse){

        return modelMapper.map(getPetsObterResponse, Pets.class);

    }

    private PostAdocaoResponse postAdocaoResponse(Adocao adocaoCriada) {

        return modelMapper.map(adocaoCriada, PostAdocaoResponse.class);

    }

    private PathAdocaoResponse pathAdocaoResponse(Adocao adocaoAtualizada) {

        return modelMapper.map(adocaoAtualizada, PathAdocaoResponse.class);

    }

    private GetAdocaoOberResponse getAdocaoOberResponse(Adocao adocaoObter) {

        return modelMapper.map(adocaoObter, GetAdocaoOberResponse.class);

    }

    private GetAdocaoListarResponse getAdocaoListarResponse(Adocao adocao){

        return modelMapper.map(adocao, GetAdocaoListarResponse.class);

    }
}
