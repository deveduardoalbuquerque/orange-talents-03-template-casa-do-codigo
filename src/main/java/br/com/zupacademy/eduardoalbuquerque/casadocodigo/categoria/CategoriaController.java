package br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.categoria.erros.CategoriaDuplicada;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void SalvarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){

        if(repository.existsByNomeIgnoreCase(categoriaRequest.getNome())){
            throw new CategoriaDuplicada("Categoria Já Cadastrada!");
        }

        repository.save(categoriaRequest.toCategoria());

    }


}
