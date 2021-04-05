package br.com.zupacademy.valeria.casadocodigo.controller.request;

import br.com.zupacademy.valeria.casadocodigo.model.Cliente;
import br.com.zupacademy.valeria.casadocodigo.model.Estado;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;
import br.com.zupacademy.valeria.casadocodigo.model.TipoPessoa;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.*;



public class ClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    @NotBlank
    private String documento;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long estadoId;
    @NotNull
    private Long paisId;
    @NotBlank
    private String cep;

    public ClienteRequest(@NotBlank String nome, @NotBlank String sobrenome, TipoPessoa tipoPessoa, @NotBlank String documento, @NotBlank String email,
                          @NotBlank String telefone, @NotBlank String endereco, @NotBlank String complemento,
                          @NotBlank String cidade, @NotNull Long estadoId, @NotNull Long paisId, @NotBlank String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoPessoa = tipoPessoa;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estadoId = estadoId;
        this.paisId = paisId;
        this.cep = cep;
    }

    public Cliente converter(TipoPessoa tipoPessoa, Estado estado, Pais pais){

        return new Cliente(this.nome, this.sobrenome, this.documento, tipoPessoa, this.email, this.telefone, this.endereco, this.complemento,
                this.cidade, estado, pais, this.cep);
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getCep() {
        return cep;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
