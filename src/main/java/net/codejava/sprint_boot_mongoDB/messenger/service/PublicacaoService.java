package net.codejava.sprint_boot_mongoDB.messenger.service;

import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import net.codejava.sprint_boot_mongoDB.messenger.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public Optional<Publicacao> buscarPublicacaoPorID(String id) {
        return publicacaoRepository.findById(id);
    }
}
