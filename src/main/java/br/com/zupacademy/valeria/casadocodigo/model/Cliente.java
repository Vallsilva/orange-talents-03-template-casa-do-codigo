package br.com.zupacademy.valeria.casadocodigo.model;



import javax.persistence.*;
import java.util.Optional;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String documento;
    private TipoPessoa tipoPessoa;
    private String email;
    private String telefone;
    private String endereco;
    private String complemento;
    private String cidade;
    @ManyToOne
    private Estado estado;
    @ManyToOne
    private Pais pais;
    private String cep;


    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String documento, TipoPessoa tipoPessoa, String email, String telefone,
                   String endereco, String complemento, String cidade, Estado estado, Pais pais, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }


    public Long getId() {
        return id;
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

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }
}
