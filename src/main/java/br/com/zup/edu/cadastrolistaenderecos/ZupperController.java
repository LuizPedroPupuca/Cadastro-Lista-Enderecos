package br.com.zup.edu.cadastrolistaenderecos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/zuppers")
public class ZupperController {

    @Autowired
    private ZupperRepository zupperRepository;

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid ZupperRequest zupperRequest, UriComponentsBuilder uri){
        Zupper zupper = zupperRequest.toModel();
        zupperRepository.save(zupper);

        URI location = uri.path("/zuppers/{id}")
                .buildAndExpand(zupper.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
