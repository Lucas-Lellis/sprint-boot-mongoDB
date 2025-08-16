package net.codejava.sprint_boot_mongoDB.messenger.service;

import net.codejava.sprint_boot_mongoDB.messenger.dto.UsuarioDTO;
import net.codejava.sprint_boot_mongoDB.messenger.model.Usuario;
import net.codejava.sprint_boot_mongoDB.messenger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> acharTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome(),usuario.getEmail()))
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> acharUsuarioPorId(String id) {
        return usuarioRepository.findById(id)
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail()));
    }

    public UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.getNome(), usuarioDTO.getEmail());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail());
    }
}
