package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.controller.request.EstadoRequest;
import br.com.zupacademy.valeria.casadocodigo.controller.response.EstadoResponse;
import br.com.zupacademy.valeria.casadocodigo.model.Estado;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;
import br.com.zupacademy.valeria.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.valeria.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoResponse> cadastrarEstado(@RequestBody @Valid EstadoRequest estadoRequest){

        Pais pais = paisRepository.findById(estadoRequest.getPaisId()).get();
        Estado estado = estadoRequest.converter(pais);
        estadoRepository.save(estado);
        EstadoResponse estadoResponse = new EstadoResponse(estado);
        return ResponseEntity.ok(estadoResponse);

    }
}
