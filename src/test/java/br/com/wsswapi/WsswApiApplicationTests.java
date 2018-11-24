package br.com.wsswapi;

import br.com.wsswapi.Config.MongoConfig;
import br.com.wsswapi.document.Planeta;
import br.com.wsswapi.exceptions.PlanetaServiceException;
import br.com.wsswapi.service.PlanetaService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

import static br.com.wsswapi.config.MessageCode.REMOVIDO_SUCESSO;
import static br.com.wsswapi.config.MessageCode.SALVO_SUCESSO;
import static br.com.wsswapi.config.MessageConfig.getMensagem;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@SpringBootTest(classes = MongoConfig.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.JVM)
public class WsswApiApplicationTests {

	private static final String INDEX = ":";
	private static final int COMP_INDEX = 2;

	@Autowired
	private PlanetaService planetaService;

	@Test
	public void getTodosPlanetasTest() throws PlanetaServiceException {
		Planeta planetaSalvo = new Planeta("Tatooine", "arid", "desert");

		String msgSalvar = planetaService.save(planetaSalvo);
		assertTrue(msgSalvar.contains(getMensagem(SALVO_SUCESSO)));

		List<Planeta> planetas = planetaService.findAll();
		assertNotNull(planetas);
		assertTrue(!planetas.isEmpty());
	}

	@Test
	public void getPlanetaTest() throws PlanetaServiceException {
		Planeta planetaSalvo = new Planeta("Alderaan", "temperate", "grasslands, mountains");

		String msgSalvar = planetaService.save(planetaSalvo);
		assertTrue(msgSalvar.contains(getMensagem(SALVO_SUCESSO)));

		String id = msgSalvar.substring(msgSalvar.indexOf(INDEX) + COMP_INDEX);

		Planeta planeta = planetaService.findById(id);
		assertNotNull(planeta);
	}

	@Test
	public void getPlanetaByNomeTest() throws PlanetaServiceException {
		String nomePlanetaPrimeiro = "Yavin";
		String nomePlanetaFinal = "IV";
		String nomePlaneta = nomePlanetaPrimeiro + " " + nomePlanetaFinal;
		Planeta planetaSalvo = new Planeta(nomePlaneta, "temperate, tropical", "jungle, rainforests");

		String msgSalvar = planetaService.save(planetaSalvo);
		assertTrue(msgSalvar.contains(getMensagem(SALVO_SUCESSO)));

		List<Planeta> planetas = planetaService.findByName(nomePlaneta);
		assertNotNull(planetas);
		assertTrue(!planetas.isEmpty());

		List<Planeta> planetas_Primeiro = planetaService.findByName(nomePlanetaPrimeiro);
		assertNotNull(planetas_Primeiro);
		assertTrue(!planetas_Primeiro.isEmpty());

		List<Planeta> planetas_Final = planetaService.findByName(nomePlanetaFinal);
		assertNotNull(planetas_Final);
		assertTrue(!planetas_Final.isEmpty());
	}

	@Test
	public void salvarPlanetaTest() throws PlanetaServiceException {
		Planeta planetaSalvo = new Planeta("Hoth", "frozen", "tundra, ice caves, mountain ranges");

		String msgSalvar = planetaService.save(planetaSalvo);
		assertTrue(msgSalvar.contains(getMensagem(SALVO_SUCESSO)));

		String id = msgSalvar.substring(msgSalvar.indexOf(INDEX) + COMP_INDEX);

		Planeta planeta = planetaService.findById(id);
		assertNotNull(planeta);

		Integer quantidadeAparicao = planeta.getQuantidadeAparicao();
		assertNotNull(quantidadeAparicao);
		assertTrue(quantidadeAparicao > BigInteger.ZERO.intValue());
	}

	@Test
	public void removerPlanetaTest() throws PlanetaServiceException {
		Planeta planetaSalvo = new Planeta("Dagobah", "murky", "swamp, jungles");

		String msgSalvar = planetaService.save(planetaSalvo);
		assertTrue(msgSalvar.contains(getMensagem(SALVO_SUCESSO)));

		String id = msgSalvar.substring(msgSalvar.indexOf(INDEX) + COMP_INDEX);

		Planeta planeta = planetaService.findById(id);
		assertNotNull(planeta);

		String msgExcluir = planetaService.deleteById(id);
		assertTrue(msgExcluir.contains(getMensagem(REMOVIDO_SUCESSO)));
	}
}

