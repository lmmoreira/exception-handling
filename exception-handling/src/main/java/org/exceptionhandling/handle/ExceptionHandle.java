package org.exceptionhandling.handle;

import org.exceptionhandling.context.ContextManager;
import org.exceptionhandling.core.AbstractExceptionPerform;
import org.exceptionhandling.delegation.DelegatingExceptionHandler;
import org.exceptionhandling.delegation.ExceptionHandler;
import org.exceptionhandling.handlers.AbstractHandler;
import org.exceptionhandling.utils.ServiceLocator;

public class ExceptionHandle extends AbstractExceptionPerform {

	public Object handle(Exception ex) {

		boolean handled = false;

		ContextManager contextManager = (ContextManager) ServiceLocator.getServiceImplementation(ContextManager.class);

		ExceptionHandler exceptionHandlers = contextManager.getExceptionHandler();

		for (DelegatingExceptionHandler exceptionHandler : exceptionHandlers.getExceptionHandlers()) {

			if (ex.getClass().equals(exceptionHandler.getException().getClass())) {

				for (AbstractHandler handler : exceptionHandler.getHandlers()) {

					handler.handle(ex);

					handled = true;

				}
			}
		}

		if (!handled) {
			throw (RuntimeException) ex;
		}

		return null;

	}

}
