package br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.Groups;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @NotNull (groups = Groups.Categoria.class)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
