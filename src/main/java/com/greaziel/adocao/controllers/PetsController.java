package com.greaziel.adocao.controllers;


import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.domains.Pessoa;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsService petsService;

    @PostMapping
    public ResponseEntity<Pets> criar(@RequestBody Pets pets) {
        Pets petAtualizado = petsService.criar(pets);
        return ResponseEntity.created(null).body(petAtualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pets> atualizar(@RequestBody Pets pets, @PathVariable int id) {
        Pets petAtualizado = petsService.atualizar(pets, id);
        return ResponseEntity.ok(petAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        petsService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> obter(@PathVariable int id) {
        Pets petObter = petsService.obter(id);
        return ResponseEntity.ok(petObter);

    }

    @GetMapping
    public ResponseEntity<List<Pets>> listar() {
        List<Pets> listaPet = petsService.listar();
        return ResponseEntity.ok(listaPet);
    }

    @GetMapping("/math")
    public ResponseEntity<List<Pets>> mathPetDonatario(@RequestParam Integer idDonatario) {
        List<Pets> petMath = petsService.mathPetDonatario(idDonatario);
        return ResponseEntity.ok(petMath);
    }
}
