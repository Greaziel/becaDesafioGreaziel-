package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PathPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.PetsInterface;
import com.greaziel.adocao.repositorys.PetsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsService implements PetsInterface {

    private final PetsRepository petsRepository;

    private final DoadorSevice doadorSevice;

    private final DonatarioService donatarioService;

    private final ModelMapper modelMapper;

    public PostPetsResponse criar(PostPetsRequest postPetsRequest) {

        if (postPetsRequest.getNome().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }

        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(postPetsRequest.getProprietario());
        Doador doador = this.getDoadorObterResponse(getDoadorObterResponse);

        Pets petsCriado = this.postPetsRequest(postPetsRequest);
        petsCriado.setProprietario(doador);
        petsRepository.save(petsCriado);

        return this.postPetsResponse(petsCriado);

    }

    public PathPetsResponse atualizar(PathPetsRequest pathPetsRequest, Integer id) {

        if (pathPetsRequest.getNome().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }

        Pets petObtido = petsRepository.findById(id).get();
        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(pathPetsRequest.getProprietario());
        Doador doador = this.getDoadorObterResponse(getDoadorObterResponse);

        Pets petAtualizado = this.pathPetsRequest(pathPetsRequest);
        petAtualizado.setId(petObtido.getId());
        petAtualizado.setProprietario(doador);
        petsRepository.save(petAtualizado);

        return this.pathPetsResponse(petAtualizado);

    }

    public void deletar(Integer id) {
        petsRepository.deleteById(id);
    }

    public GetPetsObterResponse obter(Integer id) {

        Pets petObtido = petsRepository.findById(id).get();
        ;

        return this.getPetsObterResponse(petObtido);

    }


    public List<GetPetsListarResponse> listar() {

        List<Pets> listaPets = petsRepository.findAll();
        List<GetPetsListarResponse> petsListarResponses = new ArrayList<>();

        listaPets.stream().forEach(pets ->
                petsListarResponses.add(this.getPetsListarResponse(pets)));

        return petsListarResponses;
    }

//    public List<GetPetsMathResponse> mathPetDonatario(Integer idDonatario) {
//
//        List<Pets> listaPets = petsRepository.
//
//
//        return List.of(
//                pets1,
//                pets2
//        );
//
//    }

    private Doador getDoadorObterResponse(GetDoadorObterResponse getDoadorObterResponse) {

        return modelMapper.map(getDoadorObterResponse, Doador.class);

    }

    private Pets postPetsRequest(PostPetsRequest postPetsRequest) {

        return modelMapper.map(postPetsRequest, Pets.class);

    }

    private PostPetsResponse postPetsResponse(Pets petsCriado) {

        return modelMapper.map(petsCriado, PostPetsResponse.class);

    }

    private Pets pathPetsRequest(PathPetsRequest pathPetsRequest) {

        return modelMapper.map(pathPetsRequest, Pets.class);

    }

    private PathPetsResponse pathPetsResponse(Pets petAtualizado) {

        return modelMapper.map(petAtualizado, PathPetsResponse.class);

    }

    private GetPetsObterResponse getPetsObterResponse(Pets petObtido) {

        return modelMapper.map(petObtido, GetPetsObterResponse.class);

    }

    private GetPetsListarResponse getPetsListarResponse(Pets pets) {

        return modelMapper.map(pets, GetPetsListarResponse.class);
    }
}
