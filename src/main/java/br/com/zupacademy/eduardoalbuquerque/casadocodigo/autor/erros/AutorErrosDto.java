package br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.erros;

import org.springframework.validation.FieldError;

public class AutorErrosDto {

    private String campo;
    private String mensagem;

    public AutorErrosDto(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
