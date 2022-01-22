package com.greaziel.adocao.controllers;


import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Pessoa;
import com.greaziel.adocao.domains.Pets;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @PostMapping
    public ResponseEntity<Pets> criar(@RequestBody Pets pets) {
        pets.setId(3);
        return ResponseEntity.created(null).body(pets);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pets> atualizar(@RequestBody Pets pets, @PathVariable int id){
        pets.setId(id);
        return ResponseEntity.ok(pets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> obter(@PathVariable int id){
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

        return ResponseEntity.ok(pets);

    }

    @GetMapping
    public ResponseEntity<List<Pets>> listar(){
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

        return ResponseEntity.ok(List.of(
                pets1,
                pets2,
                pets3
        ));
    }

    @GetMapping("/math")
    public ResponseEntity<List<Pets>> mathPetDonatario(@RequestParam Integer idDonatario){
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

        return ResponseEntity.ok(List.of(
                pets1,
                pets2,
                pets3
        ));
    }
}
