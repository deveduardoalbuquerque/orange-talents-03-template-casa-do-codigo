package br.com.zupacademy.eduardoalbuquerque.casadocodigo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
