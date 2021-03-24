package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.valeria.casadocodigo.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorResponse> cadastraAutor(@Valid @RequestBody AutorRequest autorRequest){
        Autor autor = autorRequest.converter();
        autorRepository.save(autor);
        AutorResponse autorResponse = new AutorResponse(autor);
        return ResponseEntity.ok(autorResponse);

    }


}
