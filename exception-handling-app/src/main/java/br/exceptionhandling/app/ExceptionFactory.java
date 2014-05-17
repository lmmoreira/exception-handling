package br.exceptionhandling.app;

public class ExceptionFactory {

	public void ilegalArgument(){
		throw new IllegalArgumentException("Mensagem de Ilegal Argument");
	}
	
	public int indexOutOfBounds(){
		throw new IndexOutOfBoundsException("Mensagem de Index Out of Bounds");
	}
	
	public int arithimetic(){
		throw new ArithmeticException("Mensagem de Arithimetic Exception");
	}
	
	public int arrayStore(){
		throw new ArrayStoreException("Mensagem de ArrayStoreException");
	}
	
}
