package br.com.zupacademy.valeria.casadocodigo.repository;

import br.com.zupacademy.valeria.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
    Optional<Autor> findByEmail( String email);
}
