package br.com.zupacademy.valeria.casadocodigo.controller.response;

import br.com.zupacademy.valeria.casadocodigo.model.Estado;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;

public class EstadoResponse {

    private String estado;
    private Pais pais;

    public EstadoResponse(Estado estado) {
        this.estado = estado.getEstado();
        this.pais = estado.getPais();
    }

    public String getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }
}
