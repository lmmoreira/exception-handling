package org.exceptionhandling.delegation;

import java.util.List;

public class ExceptionHandler {

	private List<DelegatingExceptionHandler> exceptionHandlers;

	public List<DelegatingExceptionHandler> getExceptionHandlers() {
		return exceptionHandlers;
	}

	public void setExceptionHandlers(List<DelegatingExceptionHandler> exceptionHandlers) {
		this.exceptionHandlers = exceptionHandlers;
	}
	
}
