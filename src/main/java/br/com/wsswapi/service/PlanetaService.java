package br.com.wsswapi.service;

import br.com.wsswapi.document.Planeta;
import br.com.wsswapi.exceptions.PlanetaServiceException;

import java.util.List;

/**
 * Interface de serviço do banco de dados referente ao planeta.
 */
public interface PlanetaService {

	/**
	 * Recupera todos os planetas.
	 *
	 * @return
	 * @throws PlanetaServiceException
	 */
	List<Planeta> findAll() throws PlanetaServiceException;

	/**
	 * Recupera o {@link Planeta} conforme o id fornecido.
	 *
	 * @param id
	 * @return
	 * @throws PlanetaServiceException
	 */
	Planeta findById(final String id) throws PlanetaServiceException;

	/**
	 * Recupera os planetas conforme o nome fornecido.
	 *
	 * @param nome
	 * @return
	 * @throws PlanetaServiceException
	 */
	List<Planeta> findByName(final String nome) throws PlanetaServiceException;

	/**
	 * Salva ou atualiza o {@link Planeta}.
	 *
	 * @param planeta
	 * @return
	 * @throws PlanetaServiceException
	 */
	String save(final Planeta planeta) throws PlanetaServiceException;


	/**
	 * Remove o {@link Planeta} conforme o id fornecido.
	 *
	 * @param id
	 * @return
	 * @throws PlanetaServiceException
	 */
	String deleteById(final String id) throws PlanetaServiceException;
}
