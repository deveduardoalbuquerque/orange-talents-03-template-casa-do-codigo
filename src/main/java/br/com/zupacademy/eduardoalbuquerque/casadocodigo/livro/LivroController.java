package br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.apierrors.CategoriaOuAutorNaoEncontrado;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.Autor;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.Categoria;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public ResponseEntity<?> salvarLivro(@RequestBody @Valid LivroRequest livroRequest)  {

        //verificar a categoria
        Optional<Categoria> categoria = categoriaRepository.findById(livroRequest.getCategoria().getId());
        Optional<Autor> autor = autorRepository.findById(livroRequest.getAutor().getId());
        if(categoria.isPresent() && autor.isPresent()){
            return ResponseEntity.ok(repository.save(livroRequest.toLivro(categoria.get(),autor.get())));
        }

        throw new CategoriaOuAutorNaoEncontrado("Id da Categoria ou do Autor nao encontrado!");

    }

    @GetMapping
    public List<LivroResponse> listarTodos(){
        LivroResponse livroResponse = new LivroResponse();
        return livroResponse.toLivroResponse(repository.findAll());
    }

}
