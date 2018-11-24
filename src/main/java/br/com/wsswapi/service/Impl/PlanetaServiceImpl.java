package br.com.wsswapi.service.Impl;

import br.com.wsswapi.document.Planeta;
import br.com.wsswapi.dto.PlanetaSWDTO;
import br.com.wsswapi.dto.ResultadoDTO;
import br.com.wsswapi.exceptions.PlanetaServiceException;
import br.com.wsswapi.repository.PlanetaRepository;
import br.com.wsswapi.service.PlanetaService;
import br.com.wsswapi.wsclient.SWApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static br.com.wsswapi.config.MessageCode.*;
import static br.com.wsswapi.config.MessageConfig.getMensagem;

/**
 * Classe de serviço do banco de dados referente ao planeta.
 */
@Service
public class PlanetaServiceImpl implements PlanetaService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final static String MSG_ID = " ID: ";

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private SWApiClient swApiClient;

	@Override
	public List<Planeta> findAll() throws PlanetaServiceException {
		try {
			return planetaRepository.findAll();
		} catch (Exception e) {
			String msg = getMensagem(FALHA_BUSCAR_PLANETAS);
			logger.error(msg, e);
			throw new PlanetaServiceException(msg, e);
		}
	}

	@Override
	public Planeta findById(String id) throws PlanetaServiceException {
		try {
			return planetaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			String msg = getMensagem(FALHA_BUSCAR_PLANETA_POR_ID);
			logger.error(msg, e);
			throw new PlanetaServiceException(msg, e);
		}
	}

	@Override
	public List<Planeta> findByName(String nome) throws PlanetaServiceException {
		try {
			return planetaRepository.findByName(nome);
		} catch (Exception e) {
			String msg = getMensagem(FALHA_BUSCAR_PLANETA_POR_NOME);
			logger.error(msg, e);
			throw new PlanetaServiceException(msg, e);
		}
	}

	@Override
	public String save(Planeta planeta) throws PlanetaServiceException {
		try {
			ResultadoDTO resultadoDTO = swApiClient.getFilmes(planeta.getNome());

			PlanetaSWDTO planetaSWDTO = resultadoDTO.getResults().stream().filter(
					planetaDTO -> planeta.getNome().equalsIgnoreCase(planetaDTO.getName())
			).findFirst().orElse(null);

			planeta.setQuantidadeAparicao(
					planetaSWDTO == null ? BigInteger.ZERO.intValue() : planetaSWDTO.getAmountFilms());

			Planeta planetaPersistido = planetaRepository.save(planeta);
			return getMensagem(SALVO_SUCESSO) + MSG_ID + planetaPersistido.getId();
		} catch (Exception e) {
			String msg = getMensagem(SALVO_FALHA);
			logger.error(msg, e);
			throw new PlanetaServiceException(msg, e);
		}
	}

	@Override
	public String deleteById(String id) throws PlanetaServiceException {
		try {
			planetaRepository.deleteById(id);
			return getMensagem(REMOVIDO_SUCESSO) + MSG_ID + id;
		} catch (Exception e) {
			String msg = getMensagem(REMOVIDO_FALHA);
			logger.error(msg, e);
			throw new PlanetaServiceException(msg, e);
		}
	}
}
