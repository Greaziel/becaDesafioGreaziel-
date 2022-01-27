package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.Donatario;
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
    public ResponseEntity<Donatario> criar(@RequestBody Donatario donatario){
        Donatario donatarioCriado = donatarioService.criar(donatario);
        return ResponseEntity.created(null).body(donatarioCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Donatario> atualizar(@RequestBody Donatario donatario, @PathVariable int id){
        Donatario donatarioAtualizado = donatarioService.atualizar(donatario, id);
        return ResponseEntity.ok(donatarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        donatarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donatario> obter(@PathVariable int id){
        Donatario donatarioObtido = donatarioService.obter(id);

        return ResponseEntity.ok(donatarioObtido);
    }

    @GetMapping
    public ResponseEntity<List<Donatario>> listar(){
        List<Donatario> listaDonatario = donatarioService.listar();

        return ResponseEntity.ok(listaDonatario);
    }
}
