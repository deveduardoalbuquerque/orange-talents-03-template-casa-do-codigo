package br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class CategoriaRequest {

    @NotBlank
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
