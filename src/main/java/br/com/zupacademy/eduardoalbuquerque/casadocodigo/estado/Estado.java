package br.com.zupacademy.eduardoalbuquerque.casadocodigo.estado;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
