package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.dtos.requests.PatchDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.GetDonatarioListarResponse;
import com.greaziel.adocao.dtos.responses.GetDonatarioObterResponse;
import com.greaziel.adocao.dtos.responses.PatchDonatarioResponse;
import com.greaziel.adocao.dtos.responses.PostDonatarioResponse;
import com.greaziel.adocao.exceptions.TamanhoNaoValidoExeption;
import com.greaziel.adocao.interfaces.DonatarioInterface;
import com.greaziel.adocao.repositorys.DonatarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonatarioService implements DonatarioInterface {

    private final DonatarioRepository donatarioRepository;

    private final ModelMapper modelMapper;

    public PostDonatarioResponse criar(PostDonatarioRequest postDonatarioRequest) {

        if (postDonatarioRequest.getNome().length() <= 3) {
            throw new TamanhoNaoValidoExeption("Nome não pode ser menor do que 3 caracteres");
        }

        Donatario donatarioCriado = this.postDonatarioRequest(postDonatarioRequest);
        donatarioRepository.save(donatarioCriado);

        return this.postDonatarioResponse(donatarioCriado);

    }

    public PatchDonatarioResponse atualizar(PatchDonatarioRequest pathDonatarioRequest, Integer id) {

        Donatario donatarioObtido = donatarioRepository.findById(id).get();
        Donatario donatarioAtualizado = this.pathDonatarioResquest(pathDonatarioRequest);
        donatarioAtualizado.setId(donatarioObtido.getId());
        if (pathDonatarioRequest.getNome().length() <= 3) {
            throw new TamanhoNaoValidoExeption("Nome não pode ser menor do que 3 caracteres");
        }
        donatarioRepository.save(donatarioAtualizado);

        return this.pathDonatarioResponse(donatarioAtualizado);

    }

    public void deletar(Integer id) {
        donatarioRepository.deleteById(id);
    }

    public GetDonatarioObterResponse obter(Integer id) {
        Donatario donatarioObtido = donatarioRepository.findById(id).get();

        return this.getDonatarioObterResponse(donatarioObtido);

    }



    public List<GetDonatarioListarResponse> listar() {

        List<Donatario> listaDonatario = donatarioRepository.findAll();

        return listaDonatario.stream().map(this::getDonatarioListarResponse)
                .collect(Collectors.toList());
    }
    public Donatario postDonatarioRequest(PostDonatarioRequest postDonatarioRequest) {

        return modelMapper.map(postDonatarioRequest, Donatario.class);

    }

    public PostDonatarioResponse postDonatarioResponse(Donatario donatarioCriado) {

        return modelMapper.map(donatarioCriado, PostDonatarioResponse.class);

    }

    public Donatario pathDonatarioResquest(PatchDonatarioRequest pathDonatarioRequest) {

        return modelMapper.map(pathDonatarioRequest, Donatario.class);

    }

    public PatchDonatarioResponse pathDonatarioResponse(Donatario donatarioObtido) {

        return modelMapper.map(donatarioObtido, PatchDonatarioResponse.class);

    }

    public GetDonatarioObterResponse getDonatarioObterResponse(Donatario donatarioObtido) {

        return modelMapper.map(donatarioObtido, GetDonatarioObterResponse.class);

    }

    public GetDonatarioListarResponse getDonatarioListarResponse(Donatario donatario){

        return modelMapper.map(donatario, GetDonatarioListarResponse.class);
    }
}
