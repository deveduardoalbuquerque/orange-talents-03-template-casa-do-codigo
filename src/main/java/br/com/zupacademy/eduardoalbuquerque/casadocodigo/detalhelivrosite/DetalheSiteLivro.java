package br.com.zupacademy.eduardoalbuquerque.casadocodigo.detalhelivrosite;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.Autor;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro.Livro;
import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

import java.math.BigDecimal;

public class DetalheSiteLivro {
    private String titulo;
    private String subTitulo;
    private String resumo;
    private String sumario;
    private Integer nPaginas;
    private BigDecimal valorLivro;
    private String isbn;

    private DetalheSiteAutor autor;

    public DetalheSiteLivro(Livro livro) {
        this.titulo = livro.getTitulo();
        this.subTitulo = livro.getSubTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.nPaginas = livro.getPaginas();
        this.valorLivro = livro.getPreco();
        this.isbn = livro.getIsbn();
        this.autor = new DetalheSiteAutor(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getnPaginas() {
        return nPaginas;
    }

    public BigDecimal getValorLivro() {
        return valorLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalheSiteAutor getAutor() {
        return autor;
    }
}
