package br.com.wsswapi.controller;

import br.com.wsswapi.document.Planeta;
import br.com.wsswapi.exceptions.PlanetaServiceException;
import br.com.wsswapi.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe de controle responsável pela manipulação de informações do {@link Planeta}.
 */
@RestController
@RequestMapping(path = "/api/planeta")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	/**
	 * Recupera todos os planetas.
	 *
	 * @return
	 * @throws PlanetaServiceException
	 */
	@GetMapping(path = "/listar")
	@ResponseBody
	public List<Planeta> getTodosPlanetas() throws PlanetaServiceException {
		return planetaService.findAll();
	}

	/**
	 * Recupera o {@link Planeta} conforme o id informado.
	 *
	 * @param id
	 * @return
	 * @throws PlanetaServiceException
	 */
	@GetMapping(path = "/{id}")
	@ResponseBody
	public Planeta getPlaneta(@PathVariable String id) throws PlanetaServiceException {
		return planetaService.findById(id);
	}

	/**
	 * Recupera os planetas conforme o nome informado.
	 *
	 * @param nome
	 * @return
	 * @throws PlanetaServiceException
	 */
	@GetMapping(path = "/buscar/{nome}")
	@ResponseBody
	public List<Planeta> getPlanetaByNome(@PathVariable String nome) throws PlanetaServiceException {
		return planetaService.findByName(nome);
	}

	/**
	 * Salva o {@link Planeta}.
	 *
	 * @param planeta
	 * @return
	 * @throws PlanetaServiceException
	 */
	@PostMapping
	@ResponseBody
	public String salvarPlaneta(@RequestBody Planeta planeta) throws PlanetaServiceException {
		return planetaService.save(planeta);
	}

	/**
	 * Remove o {@link Planeta}.
	 *
	 * @param id
	 * @return
	 * @throws PlanetaServiceException
	 */
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String removerPlaneta(@PathVariable String id) throws PlanetaServiceException {
		return planetaService.deleteById(id);
	}
}
