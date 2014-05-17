package br.exceptionhandlingweb.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ExceptionController {

	public void ilegalArgument() {
		throw new IllegalArgumentException("Mensagem de Ilegal Argument");
	}

	public void indexOutOfBounds() {
		throw new IndexOutOfBoundsException("Mensagem de Index Out of Bounds");
	}

	public void arithimetic() {
		throw new ArithmeticException("Mensagem de Arithimetic Exception");
	}

	public void arrayStore() {
		throw new ArrayStoreException("Mensagem de ArrayStoreException");
	}

}
