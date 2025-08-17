package net.codejava.sprint_boot_mongoDB.messenger.seeder;

import net.codejava.sprint_boot_mongoDB.messenger.dto.AutorDTO;
import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import net.codejava.sprint_boot_mongoDB.messenger.model.Usuario;
import net.codejava.sprint_boot_mongoDB.messenger.repository.PublicacaoRepository;
import net.codejava.sprint_boot_mongoDB.messenger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.TimeZone;

@Component
@Configuration
public class BancoDadosSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        usuarioRepository.deleteAll();
        publicacaoRepository.deleteAll();

        Usuario alexandre = new Usuario("Alexandre the Great", "alexandre@gmail.com");
        Usuario julius = new Usuario("Julius Caesar", "julius@gmail.com");
        Usuario napoleon = new Usuario("Napoleon Bonaparte", "napolean@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(alexandre, julius, napoleon));

        Publicacao publicacao1 = new Publicacao(format.parse("10/08/2025"), "Viagem",
                "Vou viajar pra Russia, ats. Napolean", new AutorDTO(napoleon));

        Publicacao publicacao2 = new Publicacao(format.parse("11/08/2025"), "Conquista",
                "Irei conquistar a Persia, ats. Alexandre", new AutorDTO(alexandre));
        Publicacao publicacao3 = new Publicacao(format.parse("12/08/2025"), "Pensativo",
                "Não ha mais nada que possa ser feito...", new AutorDTO(napoleon));

        publicacaoRepository.saveAll(Arrays.asList(publicacao1, publicacao2, publicacao3));

        napoleon.getPublicacaos().addAll(Arrays.asList(publicacao1, publicacao3));
        alexandre.getPublicacaos().addAll(Arrays.asList(publicacao2));

        usuarioRepository.saveAll(Arrays.asList(napoleon, alexandre));
    }
}
