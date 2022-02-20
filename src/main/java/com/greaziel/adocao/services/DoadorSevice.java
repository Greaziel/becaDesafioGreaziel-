package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.dtos.requests.PatchDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PatchDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostDoadorResponse;
import com.greaziel.adocao.interfaces.DoadorInterface;
import com.greaziel.adocao.repositorys.DoadorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoadorSevice implements DoadorInterface {

    private final DoadorRepository doadorRepository;

    private final ModelMapper modelMapper;

    public PostDoadorResponse criar(PostDoadorRequest postDoadorRequest) {

        Doador doador = this.postDoadorRequest(postDoadorRequest);
        doadorRepository.save(doador);

        return this.postDoadorResponse(doador);

    }

    public PatchDoadorResponse atualizar(PatchDoadorRequest pathDoadorRequest, Integer id) {

        Doador doadorObtido = doadorRepository.findById(id).get();
        Doador doadorAtualizado = this.pathDoadorRequest(pathDoadorRequest);
        doadorAtualizado.setId(doadorObtido.getId());
        doadorRepository.save(doadorAtualizado);

        return this.pathDoadorResponse(doadorAtualizado);

    }

    public void deletar(Integer id) {

        doadorRepository.deleteById(id);

    }

    public GetDoadorObterResponse obter(Integer id) {

        Doador doadorObtido = doadorRepository.findById(id).get();
        if (doadorObtido.getId() == null) {
            throw new RuntimeException("Doador com o id " + doadorObtido.getId() + " não encontrado");
        }

        return this.getDoadorObterResponse(doadorObtido);

    }

    public List<GetDoadorListarResponse> listar() {

        List<Doador> listaDoador = doadorRepository.findAll();

        return listaDoador.stream().map(this::converter).collect(Collectors.toList());
    }

    public Doador postDoadorRequest(PostDoadorRequest postDoadorRequest) {

        return modelMapper.map(postDoadorRequest, Doador.class);
    }

    public PostDoadorResponse postDoadorResponse(Doador doador) {

        return modelMapper.map(doador, PostDoadorResponse.class);
    }

    public Doador pathDoadorRequest(PatchDoadorRequest pathDoadorRequest) {

        return modelMapper.map(pathDoadorRequest, Doador.class);

    }

    public PatchDoadorResponse pathDoadorResponse(Doador doadorObtido) {

        return modelMapper.map(doadorObtido, PatchDoadorResponse.class);
    }

    public GetDoadorObterResponse getDoadorObterResponse(Doador doadorObtido) {

        return modelMapper.map(doadorObtido, GetDoadorObterResponse.class);
    }

    public GetDoadorListarResponse converter(Doador doador) {
        return modelMapper.map(doador, GetDoadorListarResponse.class);
    }

}
