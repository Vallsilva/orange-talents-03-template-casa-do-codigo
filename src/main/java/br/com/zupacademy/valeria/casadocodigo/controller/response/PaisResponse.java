package br.com.zupacademy.valeria.casadocodigo.controller.response;

import br.com.zupacademy.valeria.casadocodigo.model.Pais;

public class PaisResponse {

    private String nome;

    public PaisResponse(Pais nome) {
        this.nome = nome.getNome();
    }

    public String getNome() {
        return nome;
    }
}
