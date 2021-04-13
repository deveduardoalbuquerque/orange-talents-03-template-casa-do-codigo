package br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.Autor;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.Categoria;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.Groups;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.VerificaCampoDuplicado;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @VerificaCampoDuplicado(attribute = "titulo", clazz = Livro.class)
    private String titulo;

    @NotBlank
    private String subTitulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;

    @DecimalMin("20.0")
    private BigDecimal preco;

    @Min(100)
    private Integer nPaginas;

    @NotBlank
    @VerificaCampoDuplicado(attribute = "isbn",clazz = Livro.class)
    private String isbn;

    @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @Valid
    @NotNull
    @ConvertGroup(from = Default.class, to = Groups.Categoria.class)
    private Categoria categoria;

    @Valid
    @NotNull
    @ConvertGroup(from = Default.class, to = Groups.Autor.class)
    private Autor autor;


    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
                        Integer nPaginas, String isbn, LocalDate dataPublicacao,
                        Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.nPaginas = nPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getnPaginas() {
        return nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public Livro toLivro(Categoria categoria, Autor autor){

        return new Livro(this.titulo,this.subTitulo, this.resumo,this.sumario,this.preco,this.nPaginas,
                    this.isbn,this.dataPublicacao,categoria,autor);

    }
}
