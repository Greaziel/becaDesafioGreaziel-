package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Donatario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonatarioService {


    public Donatario criar(Donatario donatario){
        donatario.setId(1);
        return donatario;
    }

    public Donatario atualizar(Donatario donatario, int id){
        donatario.setId(id);
        return donatario;
    }

    public void deletar(int id){
       //
    }

    public Donatario obter(int id){
        Donatario donatario = new Donatario();
        donatario.setId(id);
        donatario.setNome("Cesar");
        donatario.setCidade("São Paulo");

        return donatario;
    }

    public List<Donatario> listar(){
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

        return List.of(
                donatario1,
                donatario2,
                donatario3
        );
    }
}
