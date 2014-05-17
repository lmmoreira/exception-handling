package br.exceptionhandling.app;

public class ExcecaoArmazenamentoEmArray extends RuntimeException {

	public ExcecaoArmazenamentoEmArray(String message) {
		super(message);
	}
	
	public ExcecaoArmazenamentoEmArray() {
		super();
	}
	
}
