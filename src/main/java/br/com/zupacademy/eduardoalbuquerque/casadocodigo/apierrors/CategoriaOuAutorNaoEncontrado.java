package br.com.zupacademy.eduardoalbuquerque.casadocodigo.apierrors;

public class CategoriaOuAutorNaoEncontrado extends RuntimeException{
    public CategoriaOuAutorNaoEncontrado(String message) {
        super(message);
    }
}
