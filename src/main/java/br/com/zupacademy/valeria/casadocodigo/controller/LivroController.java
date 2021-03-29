package br.com.zupacademy.valeria.casadocodigo.controller;



import br.com.zupacademy.valeria.casadocodigo.controller.request.LivroRequest;
import br.com.zupacademy.valeria.casadocodigo.controller.response.LivroResponse;
import br.com.zupacademy.valeria.casadocodigo.model.Autor;
import br.com.zupacademy.valeria.casadocodigo.model.Categoria;
import br.com.zupacademy.valeria.casadocodigo.model.Livro;
import br.com.zupacademy.valeria.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.valeria.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.valeria.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public Stream<LivroResponse> listaLivros(){
        List<Livro> livros = livroRepository.findAll();
        LivroResponse listaResposta = new LivroResponse();
        return listaResposta.converter(livros);
    }

    @PostMapping
    public LivroResponse salvarLivro(@RequestBody @Valid LivroRequest livroRequest){

        Categoria categoria = categoriaRepository.findById(livroRequest.getCategoria()).get();
        Autor autor = autorRepository.findById(livroRequest.getAutor()).get();


        Livro livro = livroRequest.converter(autor, categoria);
        livroRepository.save(livro);
        LivroResponse livroResponse = new LivroResponse(livro);
        return livroResponse;
    }


}
