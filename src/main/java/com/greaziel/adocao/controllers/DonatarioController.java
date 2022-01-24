package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.Donatario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donatario")
public class DonatarioController {

    @PostMapping
    public ResponseEntity<Donatario> criar(@RequestBody Donatario donatario){
        donatario.setId(1);
        return ResponseEntity.created(null).body(donatario);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Donatario> atualizar(@RequestBody Donatario donatario, @PathVariable int id){
        donatario.setId(id);
        return ResponseEntity.ok(donatario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donatario> obter(@PathVariable int id){
        Donatario donatario = new Donatario();
        donatario.setId(id);
        donatario.setNome("Cesar");
        donatario.setCidade("São Paulo");

        return ResponseEntity.ok(donatario);
    }

    @GetMapping
    public ResponseEntity<List<Donatario>> listar(){
        Donatario donatario1 = new Donatario();
        donatario1.setId(1);
        donatario1.setNome("Joao");
        donatario1.setCidade("Belo Horizonte");

        Donatario donatario2 = new Donatario();
        donatario2.setId(2);
        donatario2.setNome("Veronica");
        donatario2.setCidade("Lisboa");

        Donatario donatario3 = new Donatario();
        donatario3.setId(3);
        donatario3.setNome("Luffy");
        donatario3.setCidade("Wano");

        return ResponseEntity.ok(List.of(
                donatario1,
                donatario2,
                donatario3
        ));
    }
}
