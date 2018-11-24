package br.com.wsswapi.dto;

import br.com.wsswapi.util.JsonResultadoDTODeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * Objeto de transferência com dados do JSON do fornecidos pelo The 'Star Wars API'.
 */
@JsonDeserialize(using = JsonResultadoDTODeserializer.class)
public class ResultadoDTO {

	private Integer count;
	private List<PlanetaSWDTO> results;

	/**
	 * Construtor da classe.
	 */
	public ResultadoDTO() {
	}

	/**
	 * Construtor da classe.
	 *
	 * @param count
	 * @param results
	 */
	public ResultadoDTO(Integer count, List<PlanetaSWDTO> results) {
		this.count = count;
		this.results = results;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<PlanetaSWDTO> getResults() {
		return results;
	}

	public void setResults(List<PlanetaSWDTO> results) {
		this.results = results;
	}
}
