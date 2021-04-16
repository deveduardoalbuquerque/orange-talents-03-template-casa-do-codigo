package br.com.zupacademy.eduardoalbuquerque.casadocodigo.estado;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    boolean existsByNomeAndPais(String nome , Pais pais);
}
