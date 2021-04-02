package br.com.zupacademy.valeria.casadocodigo.controller.response;

import br.com.zupacademy.valeria.casadocodigo.model.Autor;
import br.com.zupacademy.valeria.casadocodigo.model.Categoria;
import br.com.zupacademy.valeria.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class LivroResponse {

    private String titulo;

    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int nroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroResponse() {

    }


    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.nroPaginas = livro.getNroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public LivroResponse(Optional<Livro> livro) {
        this.titulo = livro.get().getTitulo();
        this.resumo = livro.get().getResumo();
        this.sumario = livro.get().getSumario();
        this.preco = livro.get().getPreco();
        this.nroPaginas = livro.get().getNroPaginas();
        this.isbn = livro.get().getIsbn();
        this.dataPublicacao = livro.get().getDataPublicacao();
        this.categoria = livro.get().getCategoria();
        this.autor = livro.get().getAutor();
    }

    public List<LivroResponse> converter(List<Livro> livros){
        List<LivroResponse> livroResponses = livros.stream().map(LivroResponse::new).collect(Collectors.toList());
        return livroResponses;
    }




    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNroPaginas() {
        return nroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
