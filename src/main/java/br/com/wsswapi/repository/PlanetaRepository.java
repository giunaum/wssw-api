package br.com.wsswapi.repository;

import br.com.wsswapi.document.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interface de repositório do banco de dados referente ao planeta.
 */
public interface PlanetaRepository extends MongoRepository<Planeta, String>, PlanetaCustomRepository {
}
