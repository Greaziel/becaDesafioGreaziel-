package com.greaziel.adocao.controllers;

import com.greaziel.adocao.dtos.requests.PathDonatarioRequest;
import com.greaziel.adocao.dtos.requests.PostDonatarioRequest;
import com.greaziel.adocao.dtos.responses.*;
import com.greaziel.adocao.services.DonatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donatario")
public class DonatarioController {

    @Autowired
    private DonatarioService donatarioService;

    @PostMapping
    public ResponseEntity<PostDonatarioResponse> criar(@RequestBody PostDonatarioRequest postDonatarioRequest) {
        PostDonatarioResponse donatarioCriado = donatarioService.criar(postDonatarioRequest);
        return ResponseEntity.created(null).body(donatarioCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PathDonatarioResponse> atualizar(@RequestBody PathDonatarioRequest pathDonatarioRequest, @PathVariable int id) {
        PathDonatarioResponse donatarioAtualizado = donatarioService.atualizar(pathDonatarioRequest, id);
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
