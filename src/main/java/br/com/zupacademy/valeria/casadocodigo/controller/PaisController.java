package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.controller.request.PaisRequest;
import br.com.zupacademy.valeria.casadocodigo.controller.response.PaisResponse;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;
import br.com.zupacademy.valeria.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<PaisResponse> cadastrarPais(@RequestBody @Valid PaisRequest paisRequest){
        Pais pais = paisRequest.converter();
        paisRepository.save(pais);
        PaisResponse paisResponse = new PaisResponse(pais);
        return ResponseEntity.ok(paisResponse);
    }
}
