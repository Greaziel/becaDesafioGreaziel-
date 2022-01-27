package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.services.DoadorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorSevice doadorSevice;

    @PostMapping
        public ResponseEntity<Doador> criar(@RequestBody Doador doador){
        Doador doadorCriado = doadorSevice.criar(doador);
        return ResponseEntity.created(null).body(doadorCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Doador> atualizar(@RequestBody Doador doador, @PathVariable int id){
        Doador doadorAtualizado = doadorSevice.atualizar(doador, id);
        return ResponseEntity.ok(doadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        doadorSevice.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doador> obter(@PathVariable int id){
        Doador doadorObtido = doadorSevice.obter(id);
        return ResponseEntity.ok(doadorObtido);
    }

    @GetMapping
    public ResponseEntity<List<Doador>> listar() {
        List<Doador> listaDoador = doadorSevice.listar();
        return ResponseEntity.ok(listaDoador);
    }
}
