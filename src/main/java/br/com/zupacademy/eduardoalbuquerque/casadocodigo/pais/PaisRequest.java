package br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.VerificaCampoDuplicado;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @VerificaCampoDuplicado(attribute = "nome",clazz = Pais.class)
    private String nome;

    @JsonCreator
    public PaisRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toPais(){
        return new Pais(this.nome);
    }
}
