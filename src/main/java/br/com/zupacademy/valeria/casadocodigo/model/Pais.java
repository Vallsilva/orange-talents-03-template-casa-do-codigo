package br.com.zupacademy.valeria.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    public Pais() {
    }

    public Pais(@NotBlank String pais) {
        this.nome = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
