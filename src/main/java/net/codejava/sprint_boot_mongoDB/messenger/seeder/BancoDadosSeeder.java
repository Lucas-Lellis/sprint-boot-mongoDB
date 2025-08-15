package net.codejava.sprint_boot_mongoDB.messenger.seeder;

import net.codejava.sprint_boot_mongoDB.messenger.model.Usuario;
import net.codejava.sprint_boot_mongoDB.messenger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Configuration
public class BancoDadosSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.deleteAll();

        Usuario alexandre = new Usuario("Alexandre the Great", "alexandre@gmail.com");
        Usuario julius = new Usuario("Julius Caesar", "julius@gmail.com");
        Usuario napoleon = new Usuario("Napoleon Bonaparte", "napolean@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(alexandre, julius, napoleon));
    }
}
