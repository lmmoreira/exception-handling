package br.exceptionhandlingweb.except;

public class ExcecaoArmazenamentoEmArray extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoArmazenamentoEmArray(String message) {
		super(message);
	}
	
	public ExcecaoArmazenamentoEmArray() {
		super();
	}
	
}
