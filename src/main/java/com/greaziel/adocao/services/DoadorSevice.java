package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.dtos.requests.PathDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PathDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostdoadorResponse;
import com.greaziel.adocao.interfaces.DoadorInterface;
import com.greaziel.adocao.repositorys.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoadorSevice implements DoadorInterface {

    @Autowired
    private DoadorRepository doadorRepository;

    public PostdoadorResponse criar(PostDoadorRequest postDoadorRequest) {

        if(postDoadorRequest.getNome().length() <= 3){
            throw new RuntimeException("Nome inválido");
        }

        Doador doador = new Doador();
        doador.setNome(postDoadorRequest.getNome());
        doador.setCidade(postDoadorRequest.getCidade());
        doador.setLogradouro(postDoadorRequest.getLogradouro());
        doador.setEstado(postDoadorRequest.getEstado());
        doador.setCep(postDoadorRequest.getCep());
        doador.setNumero(postDoadorRequest.getNumero());
        doadorRepository.save(doador);

        PostdoadorResponse postdoadorResponse = new PostdoadorResponse();
        postdoadorResponse.setNome(doador.getNome());
        postdoadorResponse.setCidade(doador.getCidade());
        postdoadorResponse.setEstado(doador.getEstado());
        postdoadorResponse.setLogradouro(doador.getLogradouro());

        return postdoadorResponse;
    }

    public PathDoadorResponse atualizar(PathDoadorRequest pathDoadorRequest, Integer id) {

        Doador doadorObtido = doadorRepository.findById(id).get();
        doadorObtido.setNome(pathDoadorRequest.getNome());
        doadorObtido.setCidade(pathDoadorRequest.getCidade());
        doadorObtido.setCep(pathDoadorRequest.getCep());
        doadorObtido.setEstado(pathDoadorRequest.getEstado());
        doadorObtido.setLogradouro(pathDoadorRequest.getLogradouro());
        doadorObtido.setNumero(pathDoadorRequest.getNumero());
        doadorRepository.save(doadorObtido);

        PathDoadorResponse pathDoadorResponse = new PathDoadorResponse();
        pathDoadorResponse.setNome(doadorObtido.getNome());
        pathDoadorResponse.setCidade(doadorObtido.getCidade());
        pathDoadorResponse.setLogradouro(doadorObtido.getLogradouro());
        pathDoadorResponse.setEstado(doadorObtido.getEstado());

        return pathDoadorResponse;
    }

    public void deletar(Integer id) {

        doadorRepository.deleteById(id);

    }

    public GetDoadorObterResponse obter(Integer id) {

        Doador doadorObtido = doadorRepository.findById(id).get();
        if(doadorObtido.getId() == null){
            throw new RuntimeException("Doador com o id " + doadorObtido.getId() + " não encontrado");
        }

        GetDoadorObterResponse getDoadorObter = new GetDoadorObterResponse();
        getDoadorObter.setId(doadorObtido.getId());
        getDoadorObter.setNome(doadorObtido.getNome());
        getDoadorObter.setLogradouro(doadorObtido.getLogradouro());
        getDoadorObter.setCidade(doadorObtido.getCidade());
        getDoadorObter.setNumero(doadorObtido.getNumero());
        getDoadorObter.setCep(doadorObtido.getCep());
        getDoadorObter.setEstado(doadorObtido.getEstado());

        return getDoadorObter;
    }

    public List<GetDoadorListarResponse> listar() {

        List<Doador> listaDoador = doadorRepository.findAll();
        List<GetDoadorListarResponse> doadorListarResponse = new ArrayList<>();

        listaDoador.stream().forEach(doador ->
                doadorListarResponse.add(new GetDoadorListarResponse(doador)));

        return doadorListarResponse;
    }
}
