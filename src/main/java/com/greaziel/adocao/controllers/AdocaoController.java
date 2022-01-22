package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @PostMapping
    public ResponseEntity<Adocao> criar(@RequestBody Adocao adocao){
        Doador doador = new Doador();
        doador.setId(2);
        doador.setNome("Vitor");

        Pessoa donatario = new Donatario();
        donatario.setId(3);
        donatario.setNome("lilian");

        Pets pets = new Pets();
        pets.setId(5);
        pets.setNome("Zeus");
        pets.setProprietario(donatario);

        adocao.setId(1);
        adocao.setDoador(doador);
        adocao.setDonatario((Donatario) donatario);
        adocao.setAnimal(pets);

        return ResponseEntity.created(null).body(adocao);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Adocao> atualizar(@RequestBody Adocao adocao, @PathVariable int id){
        adocao.setId(id);
        return ResponseEntity.ok(adocao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adocao> obter(@PathVariable int id){
        Adocao adocao = new Adocao();
        adocao.setId(id);
        return ResponseEntity.ok(adocao);
    }

    @GetMapping
    public ResponseEntity<List<Adocao>> listar(){
        Doador doador1 = new Doador();
        doador1.setId(3);
        doador1.setNome("Pedro");

        Donatario donatario1 = new Donatario();
        donatario1.setId(4);
        doador1.setNome("Vivi");

        Pets pets1 = new Pets();
        pets1.setId(3);
        pets1.setNome("Hulk");

        Adocao adocao1 = new Adocao();
        adocao1.setId(1);
        adocao1.setAnimal(pets1);
        adocao1.setDoador(doador1);
        adocao1.setDonatario(donatario1);

        Doador doador2 = new Doador();
        doador2.setId(4);
        doador1.setNome("Ruth");

        Donatario donatario2 = new Donatario();
        donatario1.setId(1);
        doador1.setNome("Lucas");

        Pets pets2 = new Pets();
        pets1.setId(3);
        pets1.setNome("Laila");

        Adocao adocao2 = new Adocao();
        adocao2.setId(2);
        adocao2.setAnimal(pets1);
        adocao2.setDoador(doador1);
        adocao2.setDonatario(donatario1);

        Doador doador3 = new Doador();
        doador3.setId(2);
        doador1.setNome("Melissa");

        Donatario donatario3 = new Donatario();
        donatario3.setId(3);
        doador1.setNome("Renata");

        Pets pets3 = new Pets();
        pets1.setId(3);
        pets1.setNome("Mel");

        Adocao adocao3 = new Adocao();
        adocao3.setId(3);
        adocao3.setAnimal(pets1);
        adocao3.setDoador(doador1);
        adocao3.setDonatario(donatario1);

        return ResponseEntity.ok(List.of(
                adocao1,
                adocao2,
                adocao3
        ));

    }
}
