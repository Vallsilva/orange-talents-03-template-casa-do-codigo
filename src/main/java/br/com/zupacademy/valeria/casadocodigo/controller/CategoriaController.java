package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.model.Categoria;
import br.com.zupacademy.valeria.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest, BindingResult result) {

        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }
        Categoria categoria = categoriaRequest.converter();
        categoriaRepository.save(categoria);
        CategoriaResponse categoriaResponse = new CategoriaResponse(categoria);
        return ResponseEntity.ok(categoriaResponse);

    }
}