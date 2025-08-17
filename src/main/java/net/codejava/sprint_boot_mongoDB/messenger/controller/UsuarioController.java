package net.codejava.sprint_boot_mongoDB.messenger.controller;

import net.codejava.sprint_boot_mongoDB.messenger.dto.UsuarioDTO;
import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import net.codejava.sprint_boot_mongoDB.messenger.model.Usuario;
import net.codejava.sprint_boot_mongoDB.messenger.service.PublicacaoService;
import net.codejava.sprint_boot_mongoDB.messenger.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PublicacaoService publicacaoService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioService.acharTodosUsuarios();
        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable String id) {
        Optional<UsuarioDTO> usuarioDTO = usuarioService.acharUsuarioPorId(id);
        return usuarioDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioInserido = usuarioService.inserirUsuario(usuarioDTO);
        return new ResponseEntity<>(usuarioInserido, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String id) {
        usuarioService.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDTO);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}/publicacoes")
    public ResponseEntity<List<Publicacao>> buscarPublicacoesPorUsuarioId(@PathVariable String id) {
        List<Publicacao> publicacoes = usuarioService.acharPublicacoesPorUsuarioId(id);
        return new ResponseEntity<>(publicacoes, HttpStatus.OK);
    }
}