package br.com.zupacademy.valeria.casadocodigo.controller.form;

import br.com.zupacademy.valeria.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AutorForm {

    @NotNull @NotEmpty
    private String nome;
    @Email @NotEmpty @NotNull
    private String email;
    @NotEmpty @NotNull @Size(max = 400)
    private String descricao;
    @NotNull
    private LocalDateTime dataRegistro;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Autor converter(AutorForm autorForm){
        Autor autor = new Autor(autorForm.getNome(), autorForm.getEmail(), autorForm.getDescricao());
        return autor;
    }
}
