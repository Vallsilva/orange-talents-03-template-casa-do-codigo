package br.com.zupacademy.valeria.casadocodigo.controller.response;

import br.com.zupacademy.valeria.casadocodigo.model.Autor;

import java.time.LocalDateTime;


public class AutorResponse {
    private String nome;
    private String email;
    private String descicao;
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();;
        this.email = autor.getEmail();
        this.descicao = autor.getDescricao();
    }
    public AutorResponse(){

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescicao() {
        return descicao;
    }
}

