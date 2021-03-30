package br.com.zupacademy.valeria.casadocodigo.controller.request;

import br.com.zupacademy.valeria.casadocodigo.configure.anotations.UniqueValue;
import br.com.zupacademy.valeria.casadocodigo.model.Autor;

import javax.validation.constraints.*;

public class AutorRequest {

    @NotBlank
     private String nome;
    @Email @NotBlank @UniqueValue(domainClass = Autor.class, fieldName = "email")
     private String email;
    @NotBlank @Size(max = 400)
     private String descricao;

    public AutorRequest(@NotBlank String nome, @Email @NotBlank String email,
                        @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
