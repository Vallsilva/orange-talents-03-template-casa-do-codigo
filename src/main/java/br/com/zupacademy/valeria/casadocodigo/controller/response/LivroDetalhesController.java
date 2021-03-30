package br.com.zupacademy.valeria.casadocodigo.controller.response;


import br.com.zupacademy.valeria.casadocodigo.model.Livro;
import br.com.zupacademy.valeria.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/livro/detalhes")
public class LivroDetalhesController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> detalhesLivro(@PathVariable("id") Long id){

       Optional<Livro> livro = livroRepository.findById(id);
       if (livro.isPresent()){
           LivroResponse livroResponse = new LivroResponse(livro);

           return ResponseEntity.ok(livroResponse);
       }
       return ResponseEntity.badRequest().build();
    }
}
