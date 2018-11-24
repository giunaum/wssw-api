package br.com.wsswapi.repository;

import br.com.wsswapi.document.Planeta;

import java.util.List;

/**
 * Interface de repositório do banco de dados referente ao planeta.
 */
public interface PlanetaCustomRepository {

	/**
	 * Recupera o {@link Planeta} conforme o nome fornecido.
	 *
	 * @param nome
	 * @return
	 */
	List<Planeta> findByName(final String nome);
}
