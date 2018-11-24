package br.com.wsswapi.repository.Impl;

import br.com.wsswapi.document.Planeta;
import br.com.wsswapi.repository.PlanetaCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Classe de repositório do banco de dados referente ao planeta.
 */
public class PlanetaRepositoryImpl implements PlanetaCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Planeta> findByName(String nome) {
		Query query = query(where("nome").regex(nome));
		return mongoTemplate.find(query, Planeta.class);
	}
}
