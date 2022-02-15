package com.greaziel.adocao.controllers;

import com.greaziel.adocao.dtos.requests.PatchDoadorRequest;
import com.greaziel.adocao.dtos.requests.PostDoadorRequest;
import com.greaziel.adocao.dtos.responses.GetDoadorListarResponse;
import com.greaziel.adocao.dtos.responses.GetDoadorObterResponse;
import com.greaziel.adocao.dtos.responses.PatchDoadorResponse;
import com.greaziel.adocao.dtos.responses.PostDoadorResponse;
import com.greaziel.adocao.services.DoadorSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doador")
@RequiredArgsConstructor
public class DoadorController {

    private final DoadorSevice doadorSevice;

    @PostMapping
    public ResponseEntity<PostDoadorResponse> criar(@RequestBody @Valid PostDoadorRequest postDoadorRequest) {
        PostDoadorResponse doadorCriado = doadorSevice.criar(postDoadorRequest);
        return ResponseEntity.created(null).body(doadorCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchDoadorResponse> atualizar(@RequestBody @Valid PatchDoadorRequest doador, @PathVariable Integer id) {
        PatchDoadorResponse doadorAtualizado = doadorSevice.atualizar(doador, id);
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
