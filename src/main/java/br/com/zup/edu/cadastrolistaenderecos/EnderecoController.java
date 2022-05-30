package br.com.zup.edu.cadastrolistaenderecos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/{id}/enderecos")
public class EnderecoController {

    @Autowired
    private ZupperRepository zupperRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid EnderecoRequest enderecoRequest, @PathVariable Long id, UriComponentsBuilder uri){
        Zupper zupper = zupperRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zupper inexistente"));

        Endereco endereco = enderecoRequest.toModel(zupper);

        enderecoRepository.save(endereco);

        URI location = uri.path("/zuppers/{id}")
                .buildAndExpand(zupper.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
