package br.com.zupacademy.eduardoalbuquerque.casadocodigo.estado;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.Pais;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository,
                            PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> salvarEstado(@RequestBody @Valid EstadoRequest estadoRequest){

            Optional<Pais> pais = paisRepository.findById(estadoRequest.getPais().getId());

            if(pais.isPresent()){

                //preciso veriticar se estado existe no pais
                if(estadoRepository.existsByNomeAndPais(estadoRequest.getNome(),pais.get())){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Estado já existe para o pais " + pais.get().getNome());
                }

                Estado estado = estadoRequest.toEstado();
                //atualiza o pais de acordo com o ID recebido do EstadoRequest
                estado.setPais(pais.get());

                return ResponseEntity.ok(estadoRepository.save(estado));

            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID do país inválido");
        }

}
