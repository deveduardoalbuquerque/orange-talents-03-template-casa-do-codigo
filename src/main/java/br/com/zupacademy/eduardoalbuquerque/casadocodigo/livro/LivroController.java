package br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.apierrors.CategoriaOuAutorNaoEncontrado;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.Autor;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.Categoria;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository repository;
    private CategoriaRepository categoriaRepository;
    private AutorRepository autorRepository;

    public LivroController(LivroRepository repository,
                           CategoriaRepository categoriaRepository,
                           AutorRepository autorRepository) {

        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;

    }

    @PostMapping
    public ResponseEntity<?> salvarLivro(@RequestBody @Valid LivroRequest livroRequest) throws Exception {

        //verificar a categoria
        Optional<Categoria> categoria = categoriaRepository.findById(livroRequest.getCategoria().getId());
        Optional<Autor> autor = autorRepository.findById(livroRequest.getAutor().getId());
        if(categoria.isPresent() && autor.isPresent()){
            return ResponseEntity.ok(repository.save(livroRequest.toLivro(categoria.get(),autor.get())));
        }

        throw new CategoriaOuAutorNaoEncontrado("Id da Categoria ou do Autor nao encontrado!");

    }

}
