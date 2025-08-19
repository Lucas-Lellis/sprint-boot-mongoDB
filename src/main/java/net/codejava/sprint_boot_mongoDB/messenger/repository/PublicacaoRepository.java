package net.codejava.sprint_boot_mongoDB.messenger.repository;

import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PublicacaoRepository extends MongoRepository<Publicacao, String> {

    List<Publicacao> findByAutorId(String autorId);
    List<Publicacao> findByTituloContainingIgnoreCase(String titulo);

}