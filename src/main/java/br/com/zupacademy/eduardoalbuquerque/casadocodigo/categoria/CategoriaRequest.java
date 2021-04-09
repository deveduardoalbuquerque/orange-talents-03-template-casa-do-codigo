package br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.VerificaCampoDuplicado;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class CategoriaRequest {

    @NotBlank
    @VerificaCampoDuplicado(attribute = "nome",clazz = Categoria.class)
    private String nome;

    @JsonCreator
    public CategoriaRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toCategoria(){
        return new Categoria(this.nome);
    }
}
