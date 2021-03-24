package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.model.Autor;

import java.time.LocalDateTime;


public class AutorDto {
    private String nome;
    private String email;
    private String descicao;
    private LocalDateTime dataRegistro;

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();;
        this.email = autor.getEmail();
        this.descicao = autor.getDescricao();
        this.dataRegistro = autor.getDataRegistro();
    }

    public AutorDto(String nome, String email, String descricao) {
    }

    public AutorDto converterDto(Autor autor){
        AutorDto autorDto = new AutorDto(autor.getNome(), autor.getEmail(), autor.getDescricao());
        return autorDto;
    }

}

