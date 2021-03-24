package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotNull @NotEmpty
     private String nome;
    @Email @NotEmpty @NotNull
     private String email;
    @NotNull @NotEmpty @Size(max = 400)
     private String descricao;

    public AutorRequest(@NotNull @NotEmpty String nome, @Email @NotEmpty @NotNull String email,
                        @NotNull @NotEmpty @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter(){
        return new Autor(this.nome, this.email, this.descricao);
    }
}
