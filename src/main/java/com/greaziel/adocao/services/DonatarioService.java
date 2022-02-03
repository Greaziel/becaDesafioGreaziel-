package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.dtos.requests.PathDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.DonatarioInterface;
import com.greaziel.adocao.repositorys.DonatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonatarioService implements DonatarioInterface {

    @Autowired
    private DonatarioRepository donatarioRepository;

    public PostDonatarioResponse criar(PostDonatarioRequest postDonatarioRequest) {

        if (postDonatarioRequest.getNome().length() <= 3) {
            throw new RuntimeException("Nome inválido");
        }

        Donatario donatarioCriado = new Donatario();
        donatarioCriado.setNome(postDonatarioRequest.getNome());
        donatarioCriado.setCidade(postDonatarioRequest.getCidade());
        donatarioCriado.setNumero(postDonatarioRequest.getNumero());
        donatarioCriado.setLogradouro(postDonatarioRequest.getLogradouro());
        donatarioCriado.setCep(postDonatarioRequest.getCep());
        donatarioCriado.setEstado(postDonatarioRequest.getEstado());
        donatarioCriado.setPortePet(postDonatarioRequest.getPortePet());
        donatarioCriado.setTipoPet(postDonatarioRequest.getTipoPet());
        donatarioCriado.setRacaPet(postDonatarioRequest.getRacaPet());
        donatarioCriado.setCorPet(postDonatarioRequest.getCorPet());
        donatarioRepository.save(donatarioCriado);

        PostDonatarioResponse postDonatarioResponse = new PostDonatarioResponse();
        postDonatarioResponse.setNome(donatarioCriado.getNome());
        postDonatarioResponse.setCidade(donatarioCriado.getCidade());
        postDonatarioResponse.setEstado(donatarioCriado.getEstado());
        postDonatarioResponse.setPortePet(donatarioCriado.getPortePet());
        postDonatarioResponse.setRacaPet(donatarioCriado.getRacaPet());
        postDonatarioResponse.setTipoPet(donatarioCriado.getTipoPet());
        postDonatarioResponse.setCorPet(donatarioCriado.getCorPet());

        return postDonatarioResponse;
    }

    public PathDonatarioResponse atualizar(PathDonatarioRequest pathDonatarioRequest, Integer id) {

        Donatario donatarioAtualizado = donatarioRepository.findById(id).get();
        donatarioAtualizado.setNome(pathDonatarioRequest.getNome());
        donatarioAtualizado.setCidade(pathDonatarioRequest.getCidade());
        donatarioAtualizado.setCep(pathDonatarioRequest.getCep());
        donatarioAtualizado.setEstado(pathDonatarioRequest.getEstado());
        donatarioAtualizado.setLogradouro(pathDonatarioRequest.getLogradouro());
        donatarioAtualizado.setNumero(pathDonatarioRequest.getNumero());
        donatarioAtualizado.setCorPet(pathDonatarioRequest.getCorPet());
        donatarioAtualizado.setPortePet(pathDonatarioRequest.getPortePet());
        donatarioAtualizado.setRacaPet(pathDonatarioRequest.getRacaPet());
        donatarioAtualizado.setTipoPet(pathDonatarioRequest.getTipoPet());
        donatarioRepository.save(donatarioAtualizado);

        PathDonatarioResponse pathDonatarioResponse = new PathDonatarioResponse();
        pathDonatarioResponse.setNome(donatarioAtualizado.getNome());
        pathDonatarioResponse.setCidade(donatarioAtualizado.getCidade());
        pathDonatarioResponse.setEstado(donatarioAtualizado.getEstado());
        pathDonatarioResponse.setPortePet(donatarioAtualizado.getPortePet());
        pathDonatarioResponse.setRacaPet(donatarioAtualizado.getRacaPet());
        pathDonatarioResponse.setTipoPet(donatarioAtualizado.getTipoPet());
        pathDonatarioResponse.setCorPet(donatarioAtualizado.getCorPet());

        return pathDonatarioResponse;
    }

    public void deletar(Integer id) {
        donatarioRepository.deleteById(id);
    }

    public GetDonatarioObterResponse obter(Integer id) {
        Donatario donatarioObtido = donatarioRepository.findById(id).get();
        if (donatarioObtido.getId() == null) {
            throw new RuntimeException("Doador com o id " + donatarioObtido.getId() + " não encontrado");
        }
        GetDonatarioObterResponse getDonatarioObtido = new GetDonatarioObterResponse();
        getDonatarioObtido.setId(donatarioObtido.getId());
        getDonatarioObtido.setNome(donatarioObtido.getNome());
        getDonatarioObtido.setCidade(donatarioObtido.getCidade());
        getDonatarioObtido.setEstado(donatarioObtido.getEstado());
        getDonatarioObtido.setTipoPet(donatarioObtido.getTipoPet());
        getDonatarioObtido.setPortePet(donatarioObtido.getPortePet());
        getDonatarioObtido.setRacaPet(donatarioObtido.getRacaPet());
        getDonatarioObtido.setCorPet(donatarioObtido.getCorPet());

        return getDonatarioObtido;
    }

    public List<GetDonatarioListarResponse> listar() {

        List<Donatario> listaDonatario = donatarioRepository.findAll();
        List<GetDonatarioListarResponse> getDonatarioListars = new ArrayList<>();

        listaDonatario.stream().forEach(donatario ->
                getDonatarioListars.add(new GetDonatarioListarResponse(donatario)));

        return getDonatarioListars;

    }
}
