package br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
