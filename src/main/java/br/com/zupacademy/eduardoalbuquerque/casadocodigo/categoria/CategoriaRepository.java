package br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Boolean existsByNomeIgnoreCase(String nome);

}
