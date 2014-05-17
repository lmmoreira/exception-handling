package br.exceptionhandlingweb.handler;

import org.exceptionhandling.handlers.AbstractHandler;

public class MyHandler extends AbstractHandler {
	
	@Override
	public void handle(Exception exception) {
		System.out.println("Loguei " + exception.getMessage());
	}

}
