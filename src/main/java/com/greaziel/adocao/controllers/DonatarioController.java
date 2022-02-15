package com.greaziel.adocao.controllers;

import com.greaziel.adocao.dtos.requests.PatchDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.GetDonatarioListarResponse;
import com.greaziel.adocao.dtos.responses.GetDonatarioObterResponse;
import com.greaziel.adocao.dtos.responses.PatchDonatarioResponse;
import com.greaziel.adocao.dtos.responses.PostDonatarioResponse;
import com.greaziel.adocao.services.DonatarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/donatario")
@RequiredArgsConstructor
public class DonatarioController {

    private final DonatarioService donatarioService;

    @PostMapping
    public ResponseEntity<PostDonatarioResponse> criar(@RequestBody @Valid PostDonatarioRequest postDonatarioRequest) {
        PostDonatarioResponse donatarioCriado = donatarioService.criar(postDonatarioRequest);
        return ResponseEntity.created(null).body(donatarioCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchDonatarioResponse> atualizar(@RequestBody @Valid PatchDonatarioRequest pathDonatarioRequest, @PathVariable int id) {
        PatchDonatarioResponse donatarioAtualizado = donatarioService.atualizar(pathDonatarioRequest, id);
        return ResponseEntity.ok(donatarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        donatarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDonatarioObterResponse> obter(@PathVariable int id) {
        GetDonatarioObterResponse donatarioObtido = donatarioService.obter(id);

        return ResponseEntity.ok(donatarioObtido);
    }

    @GetMapping
    public ResponseEntity<List<GetDonatarioListarResponse>> listar() {
        List<GetDonatarioListarResponse> listaDonatario = donatarioService.listar();

        return ResponseEntity.ok(listaDonatario);
    }
}
