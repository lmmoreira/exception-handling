package org.exceptionhandling.delegation;

import java.util.List;

import org.exceptionhandling.handlers.AbstractHandler;

public class DelegatingExceptionHandler {

	private Exception exception;
	private List<AbstractHandler> handlers;
	
	public Exception getException() {
		return exception;
	}
	
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public List<AbstractHandler> getHandlers() {
		return handlers;
	}
	
	public void setHandlers(List<AbstractHandler> handlers) {
		this.handlers = handlers;
	}
	
}
