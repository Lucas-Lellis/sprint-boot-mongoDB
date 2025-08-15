package net.codejava.sprint_boot_mongoDB.messenger.service;

import net.codejava.sprint_boot_mongoDB.messenger.model.Usuario;
import net.codejava.sprint_boot_mongoDB.messenger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> acharTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> acharUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }
}
