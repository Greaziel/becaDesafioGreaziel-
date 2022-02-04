package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.*;
import com.greaziel.adocao.dtos.requests.PathAdocaoRequest;
import com.greaziel.adocao.dtos.requests.PostAdocaoRequest;
import com.greaziel.adocao.dtos.responses.GetAdocaoListarResponse;
import com.greaziel.adocao.dtos.responses.GetAdocaoOberResponse;
import com.greaziel.adocao.dtos.responses.PathAdocaoResponse;
import com.greaziel.adocao.dtos.responses.PostAdocaoResponse;
import com.greaziel.adocao.services.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    public ResponseEntity<PostAdocaoResponse> criar(@RequestBody PostAdocaoRequest postAdocaoRequest) {
        PostAdocaoResponse adocaoCriada = adocaoService.criar(postAdocaoRequest);
        return ResponseEntity.created(null).body(adocaoCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PathAdocaoResponse> atualizar(@RequestBody PathAdocaoRequest pathAdocaoRequest, @PathVariable int id) {
        PathAdocaoResponse adocaoAtualizada = adocaoService.atualizar(pathAdocaoRequest, id);
        return ResponseEntity.ok(adocaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        adocaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAdocaoOberResponse> obter(@PathVariable int id) {
        GetAdocaoOberResponse adocaoObtida = adocaoService.obter(id);
        return ResponseEntity.ok(adocaoObtida);
    }

    @GetMapping
    public ResponseEntity<List<GetAdocaoListarResponse>> listar() {
        List<GetAdocaoListarResponse> listaAdocao = adocaoService.listar();
        return ResponseEntity.ok(listaAdocao);

    }
}
