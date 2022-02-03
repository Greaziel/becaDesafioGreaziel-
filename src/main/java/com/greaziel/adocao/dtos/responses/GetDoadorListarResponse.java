package com.greaziel.adocao.dtos.responses;

import com.greaziel.adocao.domains.Doador;

import java.util.ArrayList;
import java.util.List;

public class GetDoadorListarResponse {

    private String nome;
    private String cidade;
    private String estado;

    public GetDoadorListarResponse(Doador doador) {
        this.setNome(doador.getNome());
        this.setCidade(doador.getCidade());
        this.setEstado(doador.getEstado());
    }

    public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public String getCidade () {
            return cidade;
        }

        public void setCidade (String cidade){
            this.cidade = cidade;
        }

        public String getEstado () {
            return estado;
        }

        public void setEstado (String estado){
            this.estado = estado;
        }
    }
