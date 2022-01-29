package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.domains.Pessoa;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.interfaces.PetsInterface;
import com.greaziel.adocao.repositorys.PetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsService implements PetsInterface {

    private final PetsRepository petsRepository;

    private final DoadorSevice doadorSevice;

    private final DonatarioService donatarioService;

    public Pets criar(Pets pets) {
        Doador doadorObtido = doadorSevice.obter(pets.getProprietario().getId());

        if (pets.getNome().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }
        pets.setProprietario(doadorObtido);
        Pets petsCriaado = petsRepository.save(pets);
        return petsCriaado;
    }

    public Pets atualizar(Pets pets, Integer id) {
        if (pets.getNome().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }
        Pets petAtualizado = this.obter(id);
        petAtualizado.setNome(pets.getNome());
        petAtualizado.setSexo(pets.getSexo());
        petAtualizado.setPeso(pets.getPeso());
        petAtualizado.setTipo(pets.getTipo());
        petAtualizado.setPorte(pets.getPorte());
        petAtualizado.setRaca(pets.getRaca());
        petAtualizado.setCor(pets.getCor());
        petAtualizado.setVacinado(pets.getVacinado());
        petAtualizado.setDoado(pets.getDoado());
        Doador doadorObtido = doadorSevice.obter(pets.getProprietario().getId());
        petAtualizado.setProprietario(doadorObtido);
        petsRepository.save(petAtualizado);

        return petAtualizado;
    }

    public void deletar(Integer id) {
        petsRepository.deleteById(id);
    }

    public Pets obter(Integer id) {
        Pets petObtido = petsRepository.findById(id).get();

        return petObtido;

    }

    public List<Pets> listar() {
        List<Pets> listaPets = petsRepository.findAll();

        return listaPets;
    }

    public List<Pets> mathPetDonatario(Integer idDonatario) {
        Pets pets1 = new Pets();
        pets1.setId(1);
        Doador doador = doadorSevice.obter(pets1.getProprietario().getId());
        pets1.setProprietario(doador);

        Pets pets2 = new Pets();
        Doador doador2 = doadorSevice.obter(pets1.getProprietario().getId());
        pets2.setProprietario(doador2);

        return List.of(
                pets1,
                pets2
        );

    }
}
