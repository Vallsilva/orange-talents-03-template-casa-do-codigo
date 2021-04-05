package br.com.zupacademy.valeria.casadocodigo.controller.response;

import br.com.zupacademy.valeria.casadocodigo.model.Cliente;

public class ClienteResponse {

    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
    private String telefone;

    public ClienteResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
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
