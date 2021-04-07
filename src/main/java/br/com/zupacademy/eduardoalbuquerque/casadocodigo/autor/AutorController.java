package br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.erros.EmailDuplicado;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void salvarAutor(@RequestBody @Valid AutorRequest autorRequest) throws MethodArgumentNotValidException{

        if(repository.existsByEmail(autorRequest.getEmail())){
            throw new EmailDuplicado("Email já cadastrado para um outro Autor(a)!");
        }
        repository.save(autorRequest.toAutor());


    }

}
