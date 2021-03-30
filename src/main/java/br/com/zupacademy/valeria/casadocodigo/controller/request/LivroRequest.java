package br.com.zupacademy.valeria.casadocodigo.controller.request;


import br.com.zupacademy.valeria.casadocodigo.configure.anotations.MustExistOnDatabase;
import br.com.zupacademy.valeria.casadocodigo.configure.anotations.UniqueValue;
import br.com.zupacademy.valeria.casadocodigo.model.Autor;
import br.com.zupacademy.valeria.casadocodigo.model.Categoria;
import br.com.zupacademy.valeria.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Range(min = 20)
    private BigDecimal preco;
    @NotNull @Range( min = 100)
    private int nroPaginas;
    @Size(min = 10, max = 13) @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPublicacao;
    @MustExistOnDatabase(domainClass = Categoria.class, fieldName = "id")
    @NotNull
    private Long categoriaId;
    @NotNull @MustExistOnDatabase(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                        @NotBlank @Range(min = 20) BigDecimal preco, @NotBlank @Min(100) int nroPaginas,
                        @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.nroPaginas = nroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
        System.out.println(categoriaId);
        System.out.println(autorId);
    }

    public Livro converter(Autor autor, Categoria categoria){

        
        return new Livro(titulo, resumo, sumario, preco, nroPaginas, isbn, dataPublicacao, categoria, autor);
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

    public Long getCategoria() {
        return categoriaId;
    }

    public Long getAutor() {
        return autorId;
    }
}
