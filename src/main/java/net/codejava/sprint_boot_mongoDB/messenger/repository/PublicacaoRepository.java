package net.codejava.sprint_boot_mongoDB.messenger.repository;

import net.codejava.sprint_boot_mongoDB.messenger.model.Publicacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PublicacaoRepository extends MongoRepository<Publicacao, String> {

    List<Publicacao> findByAutorId(String autorId);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<Publicacao> findByTitulo(String titulo);

    List<Publicacao> findByTituloContainingIgnoreCase(String titulo);

}