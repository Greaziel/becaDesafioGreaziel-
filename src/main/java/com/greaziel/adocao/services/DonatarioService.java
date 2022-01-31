package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Donatario;
import com.greaziel.adocao.interfaces.DonatarioInterface;
import com.greaziel.adocao.repositorys.DonatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonatarioService implements DonatarioInterface {

    @Autowired
    private DonatarioRepository donatarioRepository;

    public Donatario criar(Donatario donatario) {
        if (donatario.getNome().length() <= 3) {
            throw new RuntimeException("Nome inválido");
        }
        Donatario donatarioCriado = donatarioRepository.save(donatario);
        return donatarioCriado;
    }

    public Donatario atualizar(Donatario donatario, Integer id) {
        Donatario donatarioAtualizar = this.obter(id);
        donatarioAtualizar.setNome(donatario.getNome());
        donatarioAtualizar.setCidade(donatario.getCidade());
        donatarioAtualizar.setCep(donatario.getCep());
        donatarioAtualizar.setEstado(donatario.getEstado());
        donatarioAtualizar.setLogradouro(donatario.getLogradouro());
        donatarioAtualizar.setNumero(donatario.getNumero());
        donatarioAtualizar.setCorPet(donatario.getCorPet());
        donatarioAtualizar.setPortePet(donatario.getPortePet());
        donatarioAtualizar.setRacaPet(donatario.getRacaPet());
        donatarioAtualizar.setTipoPet(donatario.getTipoPet());
        donatarioRepository.save(donatarioAtualizar);

        return donatarioAtualizar;
    }

    public void deletar(Integer id) {
        donatarioRepository.deleteById(id);
    }

    public Donatario obter(Integer id) {
        Donatario donatarioObtido = donatarioRepository.findById(id).get();
        if (donatarioObtido.getId() == null) {
            throw new RuntimeException("Doador com o id " + donatarioObtido.getId() + " não encontrado");
        }

        return donatarioObtido;
    }

    public List<Donatario> listar() {

        List<Donatario> listaDonatario = donatarioRepository.findAll();

        return listaDonatario;

    }
}
