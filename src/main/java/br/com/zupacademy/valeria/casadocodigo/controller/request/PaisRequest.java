package br.com.zupacademy.valeria.casadocodigo.controller.request;

import br.com.zupacademy.valeria.casadocodigo.configure.anotations.UniqueValue;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;


    public Pais converter(){
        System.out.println("Até aqui funfa também");
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
