package br.com.zupacademy.eduardoalbuquerque.casadocodigo.detalhelivrosite;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.Autor;

public class DetalheSiteAutor {
    private String nome;
    private String descricao;

    public DetalheSiteAutor(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
