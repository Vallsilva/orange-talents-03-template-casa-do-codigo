package br.com.zupacademy.valeria.casadocodigo.repository;

import br.com.zupacademy.valeria.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
