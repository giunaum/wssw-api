package br.com.wsswapi.wsclient;

import br.com.wsswapi.dto.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

/**
 * Classe Client para acessa os serviços do 'Star Wars API'.
 */
@Component
public class SWApiClient {

	@Value("${swapi.service}")
	private String URL;

	@Autowired
	private RestOperations restOperations;

	/**
	 * Retorna os filmes conforme o nome do planeta informado.
	 *
	 * @param nomePlaneta
	 * @return
	 */
	public ResultadoDTO getFilmes(final String nomePlaneta) {
		return restOperations.getForObject(URL + nomePlaneta, ResultadoDTO.class);
	}
}
