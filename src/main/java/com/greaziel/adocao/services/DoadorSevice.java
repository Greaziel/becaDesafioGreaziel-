package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import com.greaziel.adocao.interfaces.DoadorInterface;
import com.greaziel.adocao.repositorys.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorSevice implements DoadorInterface {

    @Autowired
    private DoadorRepository doadorRepository;

    public Doador criar(Doador doador) {
        if(doador.getNome().length() <= 3){
            throw new RuntimeException("Nome inválido");
        }
        Doador doadorCriado = doadorRepository.save(doador);
        return doadorCriado;
    }

    public Doador atualizar(Doador doador, Integer id) {
        Doador doadorObtido = this.obter(id);
        doadorObtido.setNome(doador.getNome());
        doadorObtido.setCidade(doador.getCidade());
        doadorObtido.setCep(doador.getCep());
        doadorObtido.setEstado(doador.getEstado());
        doadorObtido.setLogradouro(doador.getLogradouro());
        doadorObtido.setNumero(doador.getNumero());
        doadorRepository.save(doadorObtido);
        return doadorObtido;
    }

    public void deletar(Integer id) {

        doadorRepository.deleteById(id);
    }

    public Doador obter(Integer id) {
        Doador doadorObtido = doadorRepository.findById(id).get();
        if(doadorObtido.getId() == null){
            throw new RuntimeException("Doador com o id " + doadorObtido.getId() + " não encontrado");
        }

        return doadorObtido;
    }

    public List<Doador> listar() {
        List<Doador> listaDoador = doadorRepository.findAll();
        return listaDoador;
    }
}
