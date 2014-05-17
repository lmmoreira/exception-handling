package br.exceptionhandlingweb.except;

public class ExcecaoAritimetica extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoAritimetica(String message) {
		super(message);
	}
	
	public ExcecaoAritimetica() {
		super();
	}
	
}
