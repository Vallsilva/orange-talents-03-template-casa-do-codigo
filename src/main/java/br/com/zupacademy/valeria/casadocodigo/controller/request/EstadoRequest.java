package br.com.zupacademy.valeria.casadocodigo.controller.request;

import br.com.zupacademy.valeria.casadocodigo.configure.anotations.MustExistOnDatabase;
import br.com.zupacademy.valeria.casadocodigo.configure.anotations.UniqueValue;
import br.com.zupacademy.valeria.casadocodigo.model.Estado;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank @UniqueValue(domainClass = Estado.class, fieldName = "estado")
    private String estado;
    @NotNull @MustExistOnDatabase(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public EstadoRequest(@NotBlank String estado, @NotNull Long paisId) {
        this.estado = estado;
        this.paisId = paisId;
    }

    public Estado converter(Pais pais){
        return new Estado(this.estado, pais);
    }
    public String getEstado() {
        return estado;
    }

    public Long getPaisId() {
        return paisId;
    }
}
