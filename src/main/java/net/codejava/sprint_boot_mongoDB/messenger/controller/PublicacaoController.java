package net.codejava.sprint_boot_mongoDB.messenger.controller;

import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import net.codejava.sprint_boot_mongoDB.messenger.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/publicacoes")
public class PublicacaoController {

    @Autowired
     private PublicacaoService publicacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Publicacao> buscarPublicacaoPorID(@PathVariable String id) {
        Optional<Publicacao> publicacao = publicacaoService.buscarPublicacaoPorID(id);
        return publicacao.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
