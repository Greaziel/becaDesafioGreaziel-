package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.*;
import com.greaziel.adocao.interfaces.AdocaoInterface;
import com.greaziel.adocao.repositorys.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService implements AdocaoInterface {

    @Autowired
    private DoadorSevice doadorSevice;

    @Autowired
    private DonatarioService donatarioService;

    @Autowired
    private PetsService petsService;

    @Autowired
    private AdocaoRepository adocaoRepository;


    public Adocao criar(Adocao adocao) {
        Doador doador = doadorSevice.obter(adocao.getDoador().getId());
        Donatario donatario = donatarioService.obter(adocao.getDonatario().getId());
        Pets pets = petsService.obter(adocao.getAnimal().getId());
        Adocao adocaoCriada = adocaoRepository.save(adocao);

        return adocaoCriada;
    }

    public Adocao atualizar(Adocao adocao, Integer id) {
        Adocao adocaoAtualizada = this.obter(id);
        Doador doador = doadorSevice.obter(adocao.getDoador().getId());
        Donatario donatario = donatarioService.obter(adocao.getDonatario().getId());
        Pets pets = petsService.obter(adocao.getAnimal().getId());
        return adocao;
    }

    public void deletar(Integer id) {
        adocaoRepository.deleteById(id);
    }

    public Adocao obter(Integer id) {
        Adocao adocaoObter = adocaoRepository.findById(id).get();

        return adocaoObter;
    }

    public List<Adocao> listar() {
        List<Adocao> listaAdocao = adocaoRepository.findAll();

        return listaAdocao;

    }
}
