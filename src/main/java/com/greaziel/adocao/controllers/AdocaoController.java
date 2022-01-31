package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.*;
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
    public ResponseEntity<Adocao> criar(@RequestBody Adocao adocao) {
        Adocao adocaoCriada = adocaoService.criar(adocao);
        return ResponseEntity.created(null).body(adocaoCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Adocao> atualizar(@RequestBody Adocao adocao, @PathVariable int id) {
        Adocao adocaoAtualizada = adocaoService.atualizar(adocao, id);
        return ResponseEntity.ok(adocaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id) {
        adocaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adocao> obter(@PathVariable int id) {
        Adocao adocaoObtida = adocaoService.obter(id);
        return ResponseEntity.ok(adocaoObtida);
    }

    @GetMapping
    public ResponseEntity<List<Adocao>> listar() {
        List<Adocao> listaAdocao = adocaoService.listar();
        return ResponseEntity.ok(listaAdocao);

    }
}
