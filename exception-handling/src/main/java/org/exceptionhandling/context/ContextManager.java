package org.exceptionhandling.context;

import org.exceptionhandling.delegation.ExceptionHandler;
import org.exceptionhandling.delegation.ExceptionWrapper;

public interface ContextManager {

	public ExceptionHandler getExceptionHandler();
	public ExceptionWrapper getExceptionWrapper();
	
}
