package com.greaziel.adocao.controllers;


import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PathPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.services.PetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetsController {

    private final PetsService petsService;

    @PostMapping
    public ResponseEntity<PostPetsResponse> criar(@RequestBody PostPetsRequest postPetsRequest) {
        PostPetsResponse petAtualizado = petsService.criar(postPetsRequest);
        return ResponseEntity.created(null).body(petAtualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PathPetsResponse> atualizar(@RequestBody PathPetsRequest pathPetsRequest, @PathVariable int id) {
        PathPetsResponse petAtualizado = petsService.atualizar(pathPetsRequest, id);
        return ResponseEntity.ok(petAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        petsService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPetsObterResponse> obter(@PathVariable int id) {
        GetPetsObterResponse petObter = petsService.obter(id);
        return ResponseEntity.ok(petObter);

    }

    @GetMapping
    public ResponseEntity<List<GetPetsListarResponse>> listar() {
        List<GetPetsListarResponse> listaPet = petsService.listar();
        return ResponseEntity.ok(listaPet);
    }

//    @GetMapping("/math")
//    public ResponseEntity<List<GetPetsMathResponse>> mathPetDonatario(@RequestParam Integer idDonatario) {
//        List<GetPetsMathResponse> petMath = petsService.mathPetDonatario(idDonatario);
//        return ResponseEntity.ok(petMath);
//    }
}
