package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.dtos.requests.PathDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.DonatarioInterface;
import com.greaziel.adocao.repositorys.DonatarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonatarioService implements DonatarioInterface {

    private final DonatarioRepository donatarioRepository;

    private final ModelMapper modelMapper;

    public PostDonatarioResponse criar(PostDonatarioRequest postDonatarioRequest) {

        if (postDonatarioRequest.getNome().length() <= 3) {
            throw new RuntimeException("Nome inválido");
        }

        Donatario donatarioCriado = this.postDonatarioRequest(postDonatarioRequest);
        donatarioRepository.save(donatarioCriado);

        return this.postDonatarioResponse(donatarioCriado);

    }

    public PathDonatarioResponse atualizar(PathDonatarioRequest pathDonatarioRequest, Integer id) {

        Donatario donatarioObtido = donatarioRepository.findById(id).get();
        Donatario donatarioAtualizado = this.pathDonatarioResquest(pathDonatarioRequest);
        donatarioAtualizado.setId(donatarioObtido.getId());
        donatarioRepository.save(donatarioAtualizado);

        return this.pathDonatarioResponse(donatarioAtualizado);

    }

    public void deletar(Integer id) {
        donatarioRepository.deleteById(id);
    }

    public GetDonatarioObterResponse obter(Integer id) {
        Donatario donatarioObtido = donatarioRepository.findById(id).get();
        if (donatarioObtido.getId() == null) {
            throw new RuntimeException("Doador com o id " + donatarioObtido.getId() + " não encontrado");
        }
        return this.getDonatarioObterResponse(donatarioObtido);


    }



    public List<GetDonatarioListarResponse> listar() {

        List<Donatario> listaDonatario = donatarioRepository.findAll();
        List<GetDonatarioListarResponse> getDonatarioListars = new ArrayList<>();

        listaDonatario.stream().forEach(donatario ->
                getDonatarioListars.add(this.getDonatarioListarResponse(donatario)));

        return getDonatarioListars;

    }

    private Donatario postDonatarioRequest(PostDonatarioRequest postDonatarioRequest) {

        return modelMapper.map(postDonatarioRequest, Donatario.class);

    }

    private PostDonatarioResponse postDonatarioResponse(Donatario donatarioCriado) {

        return modelMapper.map(donatarioCriado, PostDonatarioResponse.class);

    }

    private Donatario pathDonatarioResquest(PathDonatarioRequest pathDonatarioRequest) {

        return modelMapper.map(pathDonatarioRequest, Donatario.class);

    }

    private PathDonatarioResponse pathDonatarioResponse(Donatario donatarioObtido) {

        return modelMapper.map(donatarioObtido, PathDonatarioResponse.class);

    }

    private GetDonatarioObterResponse getDonatarioObterResponse(Donatario donatarioObtido) {

        return modelMapper.map(donatarioObtido, GetDonatarioObterResponse.class);

    }

    private GetDonatarioListarResponse getDonatarioListarResponse(Donatario donatario){

        return modelMapper.map(donatario, GetDonatarioListarResponse.class);
    }
}
