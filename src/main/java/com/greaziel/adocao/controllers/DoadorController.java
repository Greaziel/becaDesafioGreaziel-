package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.Doador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @PostMapping
        public ResponseEntity<Doador> criar(@RequestBody Doador doador){
        doador.setId(1);
        return ResponseEntity.created(null).body(doador);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Doador> atualizar(@RequestBody Doador doador, @PathVariable int id){
        doador.setId(id);
        return ResponseEntity.ok(doador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doador> obter(@PathVariable int id){
        Doador doador = new Doador();
        doador.setId(id);
        doador.setNome("Vivi");
        doador.setCidade("Brasilia");

        return ResponseEntity.ok(doador);
    }

    @GetMapping
    public ResponseEntity<List<Doador>> listar() {
        Doador doador1 = new Doador();
        doador1.setId(1);
        doador1.setNome("Debora");
        doador1.setCidade("Brasilia");

        Doador doador2 = new Doador();
        doador2.setId(1);
        doador2.setNome("Jose");
        doador2.setCidade("Dubai");

        Doador doador3 = new Doador();
        doador3.setId(3);
        doador3.setNome("Pedro");
        doador3.setCidade("Recife");

        return ResponseEntity.ok(List.of(
                doador1,
                doador2,
                doador3
        ));
    }
}
