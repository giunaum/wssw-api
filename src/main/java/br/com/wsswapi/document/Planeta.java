package br.com.wsswapi.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe de mapeamento do document no banco que representa um objeto planeta.
 */
@Document
public class Planeta {

	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer quantidadeAparicao;

	/**
	 * Construtor da classe.
	 */
	public Planeta() {
	}

	/**
	 * Construtor da classe.
	 *
	 * @param id
	 * @param nome
	 * @param clima
	 * @param terreno
	 * @param quantidadeAparicao
	 */
	public Planeta(String id, String nome, String clima, String terreno, Integer quantidadeAparicao) {
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidadeAparicao = quantidadeAparicao;
	}

	/**
	 * Construtor da classe.
	 *
	 * @param nome
	 * @param clima
	 * @param terreno
	 * @param quantidadeAparicao
	 */
	public Planeta(String nome, String clima, String terreno, Integer quantidadeAparicao) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidadeAparicao = quantidadeAparicao;
	}

	/**
	 * Construtor da classe.
	 *
	 * @param nome
	 * @param clima
	 * @param terreno
	 */
	public Planeta(String nome, String clima, String terreno) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQuantidadeAparicao() {
		return quantidadeAparicao;
	}

	public void setQuantidadeAparicao(Integer quantidadeAparicao) {
		this.quantidadeAparicao = quantidadeAparicao;
	}
}