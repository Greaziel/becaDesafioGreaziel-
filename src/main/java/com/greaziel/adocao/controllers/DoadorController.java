package com.greaziel.adocao.controllers;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.dtos.requests.PathDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PathDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostdoadorResponse;
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
    public ResponseEntity<PostdoadorResponse> criar(@RequestBody PostDoadorRequest postDoadorRequest) {
        PostdoadorResponse doadorCriado = doadorSevice.criar(postDoadorRequest);
        return ResponseEntity.created(null).body(doadorCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PathDoadorResponse> atualizar(@RequestBody PathDoadorRequest doador, @PathVariable Integer id) {
        PathDoadorResponse doadorAtualizado = doadorSevice.atualizar(doador, id);
        return ResponseEntity.ok(doadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        doadorSevice.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDoadorObterResponse> obter(@PathVariable Integer id) {
        GetDoadorObterResponse doadorObtido = doadorSevice.obter(id);
        return ResponseEntity.ok(doadorObtido);
    }

    @GetMapping
    public ResponseEntity<List<GetDoadorListarResponse>> listar() {
        List<GetDoadorListarResponse> listaDoador = doadorSevice.listar();
        return ResponseEntity.ok(listaDoador);
    }
}
