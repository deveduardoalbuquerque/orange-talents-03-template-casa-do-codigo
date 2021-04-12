package br.com.zupacademy.eduardoalbuquerque.casadocodigo.apierrors;

public class CategoriaNaoEcontradaException extends RuntimeException {
    public CategoriaNaoEcontradaException(String msg) {
        super(msg);
    }
}
