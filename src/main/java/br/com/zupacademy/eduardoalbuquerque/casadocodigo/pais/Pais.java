package br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.Groups;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Groups.Pais.class)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString(){
        return "ID: " + this.id +
                " Nome : " + this.nome;
    }

}
