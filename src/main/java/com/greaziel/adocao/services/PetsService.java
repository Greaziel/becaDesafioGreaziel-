package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PatchPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.PetsInterface;
import com.greaziel.adocao.repositorys.PetsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PatchPetsResponse atualizar(PatchPetsRequest pathPetsRequest, Integer id) {

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

        return listaPets.stream().map(this::getPetsListarResponse)
                .collect(Collectors.toList());
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

    public Doador getDoadorObterResponse(GetDoadorObterResponse getDoadorObterResponse) {

        return modelMapper.map(getDoadorObterResponse, Doador.class);

    }

    public Pets postPetsRequest(PostPetsRequest postPetsRequest) {

        return modelMapper.map(postPetsRequest, Pets.class);

    }

    public PostPetsResponse postPetsResponse(Pets petsCriado) {

        return modelMapper.map(petsCriado, PostPetsResponse.class);

    }

    public Pets pathPetsRequest(PatchPetsRequest pathPetsRequest) {

        return modelMapper.map(pathPetsRequest, Pets.class);

    }

    public PatchPetsResponse pathPetsResponse(Pets petAtualizado) {

        return modelMapper.map(petAtualizado, PatchPetsResponse.class);

    }

    public GetPetsObterResponse getPetsObterResponse(Pets petObtido) {

        return modelMapper.map(petObtido, GetPetsObterResponse.class);

    }

    public GetPetsListarResponse getPetsListarResponse(Pets pets) {

        return modelMapper.map(pets, GetPetsListarResponse.class);
    }
}
