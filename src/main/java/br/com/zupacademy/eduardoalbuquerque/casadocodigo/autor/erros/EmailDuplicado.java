package br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.erros;

public class EmailDuplicado extends RuntimeException {

    public EmailDuplicado(String s) {
        super(s);
    }
}
