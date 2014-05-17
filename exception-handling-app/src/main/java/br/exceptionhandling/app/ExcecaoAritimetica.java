package br.exceptionhandling.app;

public class ExcecaoAritimetica extends RuntimeException {

	public ExcecaoAritimetica(String message) {
		super(message);
	}
	
	public ExcecaoAritimetica() {
		super();
	}
	
}
