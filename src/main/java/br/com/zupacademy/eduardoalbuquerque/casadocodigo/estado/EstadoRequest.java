package br.com.zupacademy.eduardoalbuquerque.casadocodigo.estado;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.Pais;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.Groups;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

public class EstadoRequest {

    @NotBlank
    private String nome;

    @Valid
    @ConvertGroup(from = Default.class, to = Groups.Pais.class)
    @NotNull
    private Pais pais;

    public EstadoRequest(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado toEstado() {
        return new Estado(nome, pais);
    }
}
