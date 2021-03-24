package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.configure.UniqueValue;
import br.com.zupacademy.valeria.casadocodigo.model.Categoria;

public class CategoriaRequest {

    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;


    public Categoria converter(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
