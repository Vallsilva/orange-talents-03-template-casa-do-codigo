package br.com.zupacademy.valeria.casadocodigo.repository;

import br.com.zupacademy.valeria.casadocodigo.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
