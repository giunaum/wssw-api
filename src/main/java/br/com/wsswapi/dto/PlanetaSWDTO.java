package br.com.wsswapi.dto;

import java.io.Serializable;

/**
 * Objeto de transferência com dados do JSON do fornecidos pelo The 'Star Wars API'.
 */
public class PlanetaSWDTO implements Serializable {

	private String name;
	private Integer amountFilms;

	/**
	 * Construtor da classe.
	 */
	public PlanetaSWDTO() {
	}

	/**
	 * Construtor da classe.
	 *
	 * @param name
	 * @param amountFilms
	 */
	public PlanetaSWDTO(String name, Integer amountFilms) {
		this.name = name;
		this.amountFilms = amountFilms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmountFilms() {
		return amountFilms;
	}

	public void setAmountFilms(Integer amountFilms) {
		this.amountFilms = amountFilms;
	}
}
