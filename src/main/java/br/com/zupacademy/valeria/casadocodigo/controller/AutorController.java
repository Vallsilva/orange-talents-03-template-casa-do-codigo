package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.AutorRepository;
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
    public ResponseEntity<Autor> cadastraAutor(@Valid @RequestBody Autor autor){
        autorRepository.save(autor);
        return ResponseEntity.ok(autor);
    }


}
