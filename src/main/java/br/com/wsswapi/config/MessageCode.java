package br.com.wsswapi.config;

/**
 * Enum com os código de exceções/mensagens.
 */
public enum MessageCode {

	FALHA_BUSCAR_PLANETAS("MSG-FALHA-BUSCAR-PLANETAS"),
	FALHA_BUSCAR_PLANETA_POR_ID("MSG-FALHA-BUSCAR-PLANETA-POR-ID"),
	FALHA_BUSCAR_PLANETA_POR_NOME("MSG-FALHA-BUSCAR-PLANETA-POR-NOME"),
	SALVO_SUCESSO("MSG-SALVO-SUCESSO"),
	SALVO_FALHA("MSG-SALVO-FALHA"),
	REMOVIDO_SUCESSO("MSG-REMOVIDO-SUCESSO"),
	REMOVIDO_FALHA("MSG-REMOVIDO-FALHA");

	private final String chave;

	/**
	 * Construtor do Enum.
	 *
	 * @param chave
	 */
	MessageCode(String chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return chave;
	}
}
