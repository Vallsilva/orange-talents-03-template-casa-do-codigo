package br.com.zupacademy.valeria.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    @ManyToOne
    private Pais pais;

    public Estado(String estado, Pais pais) {
        this.estado = estado;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }
}
