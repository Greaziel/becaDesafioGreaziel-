package com.greaziel.adocao.controllers;


import com.greaziel.adocao.dtos.requests.PatchPetsRequest;
import com.greaziel.adocao.dtos.requests.PostPetsRequest;
import com.greaziel.adocao.dtos.responses.GetPetsListarResponse;
import com.greaziel.adocao.dtos.responses.GetPetsObterResponse;
import com.greaziel.adocao.dtos.responses.PatchPetsResponse;
import com.greaziel.adocao.dtos.responses.PostPetsResponse;
import com.greaziel.adocao.services.PetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetsController {

    private final PetsService petsService;

    @PostMapping
    public ResponseEntity<PostPetsResponse> criar(@RequestBody @Valid PostPetsRequest postPetsRequest) {
        PostPetsResponse petAtualizado = petsService.criar(postPetsRequest);
        return ResponseEntity.created(null).body(petAtualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchPetsResponse> atualizar(@RequestBody @Valid PatchPetsRequest pathPetsRequest, @PathVariable int id) {
        PatchPetsResponse petAtualizado = petsService.atualizar(pathPetsRequest, id);
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
