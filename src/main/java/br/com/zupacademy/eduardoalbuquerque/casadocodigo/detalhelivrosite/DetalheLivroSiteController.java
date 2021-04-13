package br.com.zupacademy.eduardoalbuquerque.casadocodigo.detalhelivrosite;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro.Livro;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.livro.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("livrosdetalhes")
public class DetalheLivroSiteController {

    private LivroRepository repository;

    public DetalheLivroSiteController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{livroId}")
    public ResponseEntity<?> detalheLivro(@PathVariable Long livroId){
        Optional<Livro> isLivro = repository.findById(livroId);
        if(isLivro.isPresent()){
            DetalheSiteLivro detalheSiteLivro = new DetalheSiteLivro(isLivro.get());
            return ResponseEntity.ok(detalheSiteLivro);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping
    public List<Livro> listaTodos(){
        return repository.findAll();
    }



}
