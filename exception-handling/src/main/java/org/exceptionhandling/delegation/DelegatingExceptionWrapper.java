package org.exceptionhandling.delegation;

public class DelegatingExceptionWrapper {

	private Exception from;
	private Exception to;
	
	public Exception getFrom() {
		return from;
	}
	
	public void setFrom(Exception from) {
		this.from = from;
	}
	
	public Exception getTo() {
		return to;
	}
	
	public void setTo(Exception to) {
		this.to = to;
	}
	
}
