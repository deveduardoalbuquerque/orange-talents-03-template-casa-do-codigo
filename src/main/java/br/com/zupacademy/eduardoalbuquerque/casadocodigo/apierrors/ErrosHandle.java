package br.com.zupacademy.eduardoalbuquerque.casadocodigo.apierrors;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.erros.EmailDuplicado;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.erros.CategoriaDuplicada;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrosHandle {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrosResponseDto> autorValidationError(MethodArgumentNotValidException ex){

        List<ErrosResponseDto> erros = new ArrayList<>();
        List<FieldError> errorList = ex.getFieldErrors();

        errorList.forEach(e->erros.add(new ErrosResponseDto(e.getField(),e.getDefaultMessage())));

        return erros;

    }

    @ExceptionHandler(EmailDuplicado.class)
    public ErrosResponseDto emailDuplicado(EmailDuplicado ex){

        return new ErrosResponseDto("email",ex.getMessage());

    }

    @ExceptionHandler(CategoriaDuplicada.class)
    public ErrosResponseDto categoriaDuplicada(CategoriaDuplicada ex){
        return new ErrosResponseDto("Categoria",ex.getMessage());
    }



}
