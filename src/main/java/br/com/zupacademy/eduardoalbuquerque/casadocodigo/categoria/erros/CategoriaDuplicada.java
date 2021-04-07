package br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.erros;

public class CategoriaDuplicada extends RuntimeException {

    public CategoriaDuplicada(String message) {
        super(message);
    }
}

