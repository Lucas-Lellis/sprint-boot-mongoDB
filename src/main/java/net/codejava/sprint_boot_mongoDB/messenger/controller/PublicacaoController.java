package net.codejava.sprint_boot_mongoDB.messenger.controller;

import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import net.codejava.sprint_boot_mongoDB.messenger.service.PublicacaoService;
import net.codejava.sprint_boot_mongoDB.messenger.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/publicacoes")
public class PublicacaoController {

    @Autowired
     private PublicacaoService publicacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Publicacao> buscarPublicacaoPorID(@PathVariable String id) {
        Optional<Publicacao> publicacoes = publicacaoService.buscarPublicacaoPorID(id);
        return publicacoes.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Publicacao>> buscarPorTitulo(@RequestParam(value = "titulo", defaultValue = "") String titulo) {
        titulo = URL.decodeParam(titulo);
        List<Publicacao> publicacoes = publicacaoService.buscarPorTitulo(titulo);
        return new ResponseEntity<>(publicacoes, HttpStatus.OK);
    }
}
