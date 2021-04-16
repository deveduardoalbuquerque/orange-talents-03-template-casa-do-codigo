package br.com.zupacademy.eduardoalbuquerque.casadocodigo.cliente;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.estado.Estado;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.Pais;
import br.com.zupacademy.eduardoalbuquerque.casadocodigo.pais.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    private ClienteRepository clienteRepository;

    public ClienteControle(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public Long salvarCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.toCliente();
        clienteRepository.save(cliente);
        return cliente.getId();
    }

}
