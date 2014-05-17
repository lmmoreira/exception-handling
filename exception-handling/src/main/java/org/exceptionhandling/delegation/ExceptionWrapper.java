package org.exceptionhandling.delegation;

import java.util.List;


public class ExceptionWrapper {

	private List<DelegatingExceptionWrapper> exceptionWrappers;

	public List<DelegatingExceptionWrapper> getExceptionWrappers() {
		return exceptionWrappers;
	}

	public void setExceptionWrappers(List<DelegatingExceptionWrapper> exceptionWrappers) {
		this.exceptionWrappers = exceptionWrappers;
	}
	
}
