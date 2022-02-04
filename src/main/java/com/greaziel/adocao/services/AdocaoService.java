package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.*;
import com.greaziel.adocao.dtos.requests.PathAdocaoRequest;
import com.greaziel.adocao.dtos.requests.PostAdocaoRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.AdocaoInterface;
import com.greaziel.adocao.repositorys.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdocaoService implements AdocaoInterface {

    @Autowired
    private DoadorSevice doadorSevice;

    @Autowired
    private DonatarioService donatarioService;

    @Autowired
    private PetsService petsService;

    @Autowired
    private AdocaoRepository adocaoRepository;


    public PostAdocaoResponse criar(PostAdocaoRequest postAdocaoRequest) {

        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(postAdocaoRequest.getDoador());
        Doador doador = new Doador();
        doador.setId(getDoadorObterResponse.getId());
        doador.setNome(getDoadorObterResponse.getNome());
        doador.setCidade(getDoadorObterResponse.getCidade());
        doador.setLogradouro(getDoadorObterResponse.getLogradouro());
        doador.setCep(getDoadorObterResponse.getCep());
        doador.setNumero(getDoadorObterResponse.getNumero());
        doador.setEstado(getDoadorObterResponse.getEstado());

        GetDonatarioObterResponse getDonatarioObterResponse = donatarioService.obter(postAdocaoRequest.getDonatario());
        Donatario donatario = new Donatario();
        donatario.setId(getDonatarioObterResponse.getId());
        donatario.setNome(getDonatarioObterResponse.getNome());
        donatario.setCidade(getDonatarioObterResponse.getCidade());
        donatario.setEstado(getDonatarioObterResponse.getEstado());
        donatario.setPortePet(getDonatarioObterResponse.getPortePet());
        donatario.setTipoPet(getDonatarioObterResponse.getTipoPet());
        donatario.setCorPet(getDonatarioObterResponse.getCorPet());
        donatario.setRacaPet(getDonatarioObterResponse.getRacaPet());

        GetPetsObterResponse getPetsObterResponse = petsService.obter(postAdocaoRequest.getAnimal());
        Pets pets = new Pets();
        pets.setId(getPetsObterResponse.getId());
        pets.setNome(getPetsObterResponse.getNome());
        pets.setTipo(getPetsObterResponse.getCor());
        pets.setRaca(getPetsObterResponse.getRaca());
        pets.setSexo(getPetsObterResponse.getSexo());
        pets.setCor(getPetsObterResponse.getCor());
        pets.setPeso(getPetsObterResponse.getPeso());
        pets.setProprietario(doador);

        Adocao adocaoCriada = new Adocao();
        adocaoCriada.setDoador(doador);
        adocaoCriada.setDonatario(donatario);
        adocaoCriada.setAnimal(pets);
        adocaoRepository.save(adocaoCriada);

        PostAdocaoResponse postAdocaoResponse = new PostAdocaoResponse();
        postAdocaoResponse.setNomeDoador(adocaoCriada.getDoador().getNome());
        postAdocaoResponse.setNomeDonatario(adocaoCriada.getDonatario().getNome());
        postAdocaoResponse.setNomeAnimal(adocaoCriada.getAnimal().getNome());

        return postAdocaoResponse;
    }

    public PathAdocaoResponse atualizar(PathAdocaoRequest pathAdocaoRequest, Integer id) {
        Adocao adocaoAtualizada = adocaoRepository.getById(id);
        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(pathAdocaoRequest.getDoador());
        Doador doador = new Doador();
        doador.setId(getDoadorObterResponse.getId());
        doador.setNome(getDoadorObterResponse.getNome());
        doador.setCidade(getDoadorObterResponse.getCidade());
        doador.setLogradouro(getDoadorObterResponse.getLogradouro());
        doador.setCep(getDoadorObterResponse.getCep());
        doador.setNumero(getDoadorObterResponse.getNumero());
        doador.setEstado(getDoadorObterResponse.getEstado());

        GetDonatarioObterResponse getDonatarioObterResponse = donatarioService.obter(pathAdocaoRequest.getDonatario());
        Donatario donatario = new Donatario();
        donatario.setId(getDonatarioObterResponse.getId());
        donatario.setNome(getDonatarioObterResponse.getNome());
        donatario.setCidade(getDonatarioObterResponse.getCidade());
        donatario.setEstado(getDonatarioObterResponse.getEstado());
        donatario.setPortePet(getDonatarioObterResponse.getPortePet());
        donatario.setTipoPet(getDonatarioObterResponse.getTipoPet());
        donatario.setCorPet(getDonatarioObterResponse.getCorPet());
        donatario.setRacaPet(getDonatarioObterResponse.getRacaPet());

        GetPetsObterResponse getPetsObterResponse = petsService.obter(pathAdocaoRequest.getAnimal());
        Pets pets = new Pets();
        pets.setId(getPetsObterResponse.getId());
        pets.setNome(getPetsObterResponse.getNome());
        pets.setTipo(getPetsObterResponse.getCor());
        pets.setRaca(getPetsObterResponse.getRaca());
        pets.setSexo(getPetsObterResponse.getSexo());
        pets.setCor(getPetsObterResponse.getCor());
        pets.setPeso(getPetsObterResponse.getPeso());
        pets.setProprietario(doador);

        adocaoAtualizada.setId(id);
        adocaoAtualizada.setDoador(doador);
        adocaoAtualizada.setDonatario(donatario);
        adocaoAtualizada.setAnimal(pets);
        adocaoRepository.save(adocaoAtualizada);

        PathAdocaoResponse pathAdocaoResponse = new PathAdocaoResponse();
        pathAdocaoResponse.setNomeDoador(adocaoAtualizada.getDoador().getNome());
        pathAdocaoResponse.setNomeDonatario(adocaoAtualizada.getDonatario().getNome());
        pathAdocaoResponse.setNomeAnimal(adocaoAtualizada.getAnimal().getNome());

        return pathAdocaoResponse;
    }

    public void deletar(Integer id) {
        adocaoRepository.deleteById(id);
    }

    public GetAdocaoOberResponse obter(Integer id) {
        Adocao adocaoObter = adocaoRepository.findById(id).get();

        GetAdocaoOberResponse adocaoOberResponse = new GetAdocaoOberResponse();
        adocaoOberResponse.setId(adocaoObter.getId());
        adocaoOberResponse.setNomeDoador(adocaoObter.getDoador().getNome());
        adocaoOberResponse.setCidadeDoador(adocaoObter.getDoador().getCidade());
        adocaoOberResponse.setNomeDonatario(adocaoObter.getDonatario().getNome());
        adocaoOberResponse.setCidadeDonatario(adocaoObter.getDonatario().getCidade());
        adocaoOberResponse.setNomePet(adocaoObter.getAnimal().getNome());
        adocaoOberResponse.setRacaPet(adocaoObter.getAnimal().getRaca());

        return adocaoOberResponse;
    }

    public List<GetAdocaoListarResponse> listar() {
        List<Adocao> listaAdocao = adocaoRepository.findAll();
        List<GetAdocaoListarResponse> getAdocaoListarResponseList = new ArrayList<>();
        listaAdocao.forEach(adocao -> {
            GetAdocaoListarResponse getAdocaoListarResponse = new GetAdocaoListarResponse();
            getAdocaoListarResponse.setDoador(adocao.getDoador().getNome());
            getAdocaoListarResponse.setDonatario(adocao.getDonatario().getNome());
            getAdocaoListarResponse.setAnimal(adocao.getAnimal().getNome());
            getAdocaoListarResponseList.add(getAdocaoListarResponse);
        });

        return getAdocaoListarResponseList;

    }
}
