package br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<AutorErrosDto> autorvalidationError(MethodArgumentNotValidException ex){

        List<AutorErrosDto> erros = new ArrayList<>();
        List<FieldError> errorList = ex.getFieldErrors();

        errorList.forEach(e->erros.add(new AutorErrosDto(e.getField(),e.getDefaultMessage())));

        return erros;

    }

    @ExceptionHandler(EmailDuplicado.class)
    public AutorErrosDto emailDuplicado(EmailDuplicado ex){

        return new AutorErrosDto("email",ex.getMessage());

    }

}
