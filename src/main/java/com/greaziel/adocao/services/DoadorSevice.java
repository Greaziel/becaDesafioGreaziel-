package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.dtos.requests.PathDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PathDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostDoadorResponse;
import com.greaziel.adocao.interfaces.DoadorInterface;
import com.greaziel.adocao.repositorys.DoadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoadorSevice implements DoadorInterface {

    @Autowired
    private DoadorRepository doadorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PostDoadorResponse criar(PostDoadorRequest postDoadorRequest) {

        if (postDoadorRequest.getNome().length() <= 3) {
            throw new RuntimeException("Nome inválido");
        }

        Doador doador = this.postDoadorRequest(postDoadorRequest);
        doadorRepository.save(doador);

        PostDoadorResponse postDoadorResponse = this.postDoadorResponse(doador);

        return postDoadorResponse;
    }

    public PathDoadorResponse atualizar(PathDoadorRequest pathDoadorRequest, Integer id) {

        Doador doadorObtido = doadorRepository.findById(id).get();
        Doador doadorAtualizado = this.PathDoadorRequest(pathDoadorRequest);
        doadorAtualizado.setId(doadorObtido.getId());
        doadorRepository.save(doadorAtualizado);

        PathDoadorResponse pathDoadorResponse = this.pathDoadorResponse(doadorAtualizado);

        return pathDoadorResponse;
    }

    public void deletar(Integer id) {

        doadorRepository.deleteById(id);

    }

    public GetDoadorObterResponse obter(Integer id) {

        Doador doadorObtido = doadorRepository.findById(id).get();
        if (doadorObtido.getId() == null) {
            throw new RuntimeException("Doador com o id " + doadorObtido.getId() + " não encontrado");
        }

        GetDoadorObterResponse getDoadorObter = this.getDoadorObterResponse(doadorObtido);

        return getDoadorObter;
    }

    public List<GetDoadorListarResponse> listar() {

        List<Doador> listaDoador = doadorRepository.findAll();
        List<GetDoadorListarResponse> doadorListarResponse = new ArrayList<>();

        listaDoador.stream().forEach(doador ->
                doadorListarResponse.add(this.converter(doador)));

        return doadorListarResponse;
    }

    private Doador postDoadorRequest(PostDoadorRequest postDoadorRequest) {

        return modelMapper.map(postDoadorRequest, Doador.class);
    }

    private PostDoadorResponse postDoadorResponse(Doador doador) {

        return modelMapper.map(doador, PostDoadorResponse.class);
    }

    private Doador PathDoadorRequest(PathDoadorRequest pathDoadorRequest) {

        return modelMapper.map(pathDoadorRequest, Doador.class);

    }

    private PathDoadorResponse pathDoadorResponse(Doador doadorObtido) {

      return modelMapper.map(doadorObtido, PathDoadorResponse.class);
    }

    private GetDoadorObterResponse getDoadorObterResponse(Doador doadorObtido) {

    return modelMapper.map(doadorObtido, GetDoadorObterResponse.class);
    }

    public GetDoadorListarResponse converter(Doador doador) {
        return modelMapper.map(doador, GetDoadorListarResponse.class);
    }

}
