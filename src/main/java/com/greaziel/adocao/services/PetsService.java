package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Pessoa;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.interfaces.PetsInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService implements PetsInterface {

    public Pets criar(Pets pets) {
        pets.setId(3);
        return pets;
    }

    public Pets atualizar(Pets pets, int id){
        pets.setId(id);
        return pets;
    }

    public void deletar(int id){
       //
    }

    public Pets obter(int id){
        Pessoa doador = new Doador();
        doador.setId(id);
        doador.setNome("Vivi");
        doador.setCidade("Brasilia");
        Pets pets = new Pets();
        pets.setId(id);
        pets.setNome("Rex");
        pets.setCor("Branco");
        pets.setPeso(6.77);
        pets.setPorte("Pequeno");
        pets.setRaca("Pincher");
        pets.setSexo("Macho");
        pets.setTipo("Cachorro");
        pets.setVacinado(true);
        pets.setProprietario(doador);

        return pets;

    }

    public List<Pets> listar(){
        Pessoa doador1 = new Doador();
        doador1.setNome("Pedro");
        Pets pets1 = new Pets();
        pets1.setId(1);
        pets1.setNome("Hulk");
        pets1.setTipo("Cachorro");
        pets1.setProprietario(doador1);

        Pessoa doador2 = new Doador();
        doador2.setNome("Ruth");
        Pets pets2 = new Pets();
        pets2.setId(2);
        pets2.setNome("Laila");
        pets2.setTipo("Gato");
        pets2.setProprietario(doador2);

        Pessoa doador3 = new Doador();
        doador3.setNome("Felipe");
        Pets pets3 = new Pets();
        pets3.setId(3);
        pets3.setNome("Lulu");
        pets3.setTipo("Gato");
        pets3.setProprietario(doador3);

        return List.of(
                pets1,
                pets2,
                pets3
        );
    }

    public List<Pets> mathPetDonatario(Integer idDonatario){
        Pessoa doador1 = new Doador();
        doador1.setNome("Pedro");
        Pets pets1 = new Pets();
        pets1.setId(1);
        pets1.setNome("Hulk");
        pets1.setTipo("Cachorro");
        pets1.setProprietario(doador1);

        Pessoa doador2 = new Doador();
        doador2.setNome("Ruth");
        Pets pets2 = new Pets();
        pets2.setId(2);
        pets2.setNome("Laila");
        pets2.setTipo("Gato");
        pets2.setProprietario(doador2);

        Pessoa doador3 = new Doador();
        doador3.setNome("Felipe");
        Pets pets3 = new Pets();
        pets3.setId(3);
        pets3.setNome("Lulu");
        pets3.setTipo("Gato");
        pets3.setProprietario(doador3);

        return List.of(
                pets1,
                pets2,
                pets3
        );
    }
}
