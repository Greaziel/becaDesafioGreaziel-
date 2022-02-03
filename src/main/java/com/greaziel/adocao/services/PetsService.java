package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PathPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.interfaces.PetsInterface;
import com.greaziel.adocao.repositorys.PetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsService implements PetsInterface {

    private final PetsRepository petsRepository;

    private final DoadorSevice doadorSevice;

    private final DonatarioService donatarioService;

    public PostPetsResponse criar(PostPetsRequest postPetsRequest) {

        if (postPetsRequest.getNome().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }

        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(postPetsRequest.getProprietario());
        Doador doador = new Doador();
        doador.setNome(getDoadorObterResponse.getNome());
        doador.setEstado(getDoadorObterResponse.getEstado());
        doador.setCidade(getDoadorObterResponse.getCidade());
        doador.setLogradouro(getDoadorObterResponse.getLogradouro());
        doador.setNumero(getDoadorObterResponse.getNumero());
        doador.setCep(getDoadorObterResponse.getCep());

        Pets petsCriado = new Pets();
        petsCriado.setNome(postPetsRequest.getNome());
        petsCriado.setTipo(postPetsRequest.getTipo());
        petsCriado.setCor(postPetsRequest.getCor());
        petsCriado.setPorte(postPetsRequest.getPorte());
        petsCriado.setPeso(postPetsRequest.getPeso());
        petsCriado.setRaca(postPetsRequest.getRaca());
        petsCriado.setSexo(postPetsRequest.getSexo());
        petsCriado.setVacinado(postPetsRequest.getVacinado());
        petsCriado.setDoado(postPetsRequest.getDoado());
        petsCriado.setProprietario(doador);
        petsRepository.save(petsCriado);

        PostPetsResponse postPetsResponse = new PostPetsResponse();
        postPetsResponse.setNome(petsCriado.getNome());
        postPetsResponse.setPorte(petsCriado.getPorte());
        postPetsResponse.setRaca(petsCriado.getRaca());
        postPetsResponse.setPeso(petsCriado.getPeso());
        postPetsResponse.setCor(petsCriado.getCor());
        postPetsResponse.setSexo(petsCriado.getSexo());

        return postPetsResponse;
    }

    public PathPetsResponse atualizar(PathPetsRequest pathPetsRequest, Integer id) {

        if (pathPetsRequest.getNome().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }

        Pets petAtualizado = petsRepository.findById(id).get();
        GetDoadorObterResponse getDoadorObterResponse = doadorSevice.obter(pathPetsRequest.getProprietario());
        Doador doador = new Doador();
        doador.setNome(getDoadorObterResponse.getNome());
        doador.setEstado(getDoadorObterResponse.getEstado());
        doador.setCidade(getDoadorObterResponse.getCidade());
        doador.setLogradouro(getDoadorObterResponse.getLogradouro());
        doador.setNumero(getDoadorObterResponse.getNumero());
        doador.setCep(getDoadorObterResponse.getCep());

        petAtualizado.setNome(pathPetsRequest.getNome());
        petAtualizado.setSexo(pathPetsRequest.getSexo());
        petAtualizado.setPeso(pathPetsRequest.getPeso());
        petAtualizado.setTipo(pathPetsRequest.getTipo());
        petAtualizado.setPorte(pathPetsRequest.getPorte());
        petAtualizado.setRaca(pathPetsRequest.getRaca());
        petAtualizado.setCor(pathPetsRequest.getCor());
        petAtualizado.setVacinado(pathPetsRequest.getVacinado());
        petAtualizado.setDoado(pathPetsRequest.getDoado());
        petAtualizado.setProprietario(doador);
        petsRepository.save(petAtualizado);

        PathPetsResponse pathPetsResponse = new PathPetsResponse();
        pathPetsResponse.setNome(petAtualizado.getNome());
        pathPetsResponse.setPeso(petAtualizado.getPeso());
        pathPetsResponse.setPorte(petAtualizado.getPorte());
        pathPetsResponse.setRaca(petAtualizado.getRaca());
        pathPetsResponse.setSexo(petAtualizado.getSexo());
        pathPetsResponse.setCor(petAtualizado.getCor());

        return pathPetsResponse;
    }

    public void deletar(Integer id) {
        petsRepository.deleteById(id);
    }

    public GetPetsObterResponse obter(Integer id) {

        Pets petObtido = petsRepository.findById(id).get();
        GetDoadorObterResponse doadorObterResponse = new GetDoadorObterResponse();
        doadorObterResponse.setId(petObtido.getProprietario().getId());
        doadorObterResponse.setNome(petObtido.getProprietario().getNome());
        doadorObterResponse.setCidade(petObtido.getProprietario().getCidade());
        doadorObterResponse.setEstado(petObtido.getProprietario().getEstado());
        doadorObterResponse.setLogradouro(petObtido.getProprietario().getLogradouro());
        doadorObterResponse.setNumero(petObtido.getProprietario().getNumero());
        doadorObterResponse.setCep(petObtido.getProprietario().getCep());

        GetPetsObterResponse getPetsObterResponse = new GetPetsObterResponse();
        getPetsObterResponse.setId(petObtido.getId());
        getPetsObterResponse.setNome(petObtido.getNome());
        getPetsObterResponse.setRaca(petObtido.getRaca());
        getPetsObterResponse.setSexo(petObtido.getSexo());
        getPetsObterResponse.setCor(petObtido.getCor());
        getPetsObterResponse.setPeso(petObtido.getPeso());
        getPetsObterResponse.setPorte(petObtido.getPorte());
        getPetsObterResponse.setGetDoadorObterResponse(doadorObterResponse);

        return getPetsObterResponse;

    }

    public List<GetPetsListarResponse> listar() {

        List<Pets> listaPets = petsRepository.findAll();
        List<GetPetsListarResponse> petsListarResponses = new ArrayList<>();

        listaPets.stream().forEach(pets ->
                petsListarResponses.add(new GetPetsListarResponse(pets)));

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
}
