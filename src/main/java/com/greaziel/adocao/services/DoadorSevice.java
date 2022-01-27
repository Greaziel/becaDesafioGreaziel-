package com.greaziel.adocao.services;

import com.greaziel.adocao.domains.Doador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorSevice {

   public Doador criar(Doador doador){
        doador.setId(1);
        return doador;
    }

    public Doador atualizar(Doador doador, int id){
        doador.setId(id);
        return doador;
    }

    public void deletar(int id){
       //
    }

    public Doador obter(int id){
        Doador doador = new Doador();
        doador.setId(id);
        doador.setNome("Vivi");
        doador.setCidade("Brasilia");

        return doador;
    }

    public List<Doador> listar() {
        Doador doador1 = new Doador();
        doador1.setId(1);
        doador1.setNome("Debora");
        doador1.setCidade("Brasilia");

        Doador doador2 = new Doador();
        doador2.setId(2);
        doador2.setNome("Jose");
        doador2.setCidade("Dubai");

        Doador doador3 = new Doador();
        doador3.setId(3);
        doador3.setNome("Pedro");
        doador3.setCidade("Recife");

        return List.of(
                doador1,
                doador2,
                doador3
        );
    }
}
