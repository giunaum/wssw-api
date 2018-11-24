package br.com.wsswapi.exceptions;

/**
 * Classe de exceção da classe {@link br.com.wsswapi.service.PlanetaService}.
 */
public class PlanetaServiceException extends Exception {

	/**
	 * Construtor da classe.
	 *
	 * @param message
	 * @param cause
	 */
	public PlanetaServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor da classe.
	 *
	 * @param message
	 */
	public PlanetaServiceException(String message) {
		super(message);
	}
}
