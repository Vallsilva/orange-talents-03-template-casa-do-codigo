package br.com.zupacademy.valeria.casadocodigo.repository;

import br.com.zupacademy.valeria.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
