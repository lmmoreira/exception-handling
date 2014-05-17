package br.exceptionhandling.app;

public class Main {

	public static void main(String args[]){
	
		Main m = new Main();
		m.send();
		
	}	
	
	public void send(){
		
		ExceptionFactory factory = new ExceptionFactory();
		factory.ilegalArgument();
		factory.indexOutOfBounds();
		factory.arithimetic();
		factory.arrayStore();
		
	}
	
}
	