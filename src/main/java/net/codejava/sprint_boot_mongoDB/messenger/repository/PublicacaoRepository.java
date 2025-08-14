package net.codejava.sprint_boot_mongoDB.messenger.repository;

import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends MongoRepository<Publicacao, Long> {
}
