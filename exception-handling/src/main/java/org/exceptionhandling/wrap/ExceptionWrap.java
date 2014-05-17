package org.exceptionhandling.wrap;

import java.lang.reflect.Constructor;

import org.exceptionhandling.context.ContextManager;
import org.exceptionhandling.core.AbstractExceptionPerform;
import org.exceptionhandling.delegation.DelegatingExceptionWrapper;
import org.exceptionhandling.delegation.ExceptionWrapper;
import org.exceptionhandling.utils.ServiceLocator;

public class ExceptionWrap extends AbstractExceptionPerform {

	public Object wrap(Exception ex) {
		
		boolean wrapped = false;
		
		ContextManager contextManager = (ContextManager) ServiceLocator.getServiceImplementation(ContextManager.class);

		ExceptionWrapper exceptionWrappers = contextManager.getExceptionWrapper();
		
		for (DelegatingExceptionWrapper exceptionWrapper : exceptionWrappers.getExceptionWrappers()) {

			if (causeTest(ex, exceptionWrapper)) {
				
				wrapped = true;
				
				throw getWrapped(exceptionWrapper.getTo().getClass(), ex); 
				
			}
		}
		
		if (!wrapped) {
			throw (RuntimeException) ex;
		}
		
		return null;

	}
	
	public boolean causeTest(Exception ex, DelegatingExceptionWrapper exceptionWrapper){
		
		if(ex.getClass().equals(exceptionWrapper.getFrom().getClass())){
			return true;
		} else if(ex.getCause() != null){
			return causeTest((Exception) ex.getCause(), exceptionWrapper);
		}
		
		return false;
		
	}
	
	public RuntimeException getWrapped(Class<?> exceptionClass, Exception ex) {
		
		Class<?> [] stringClassParameters = new Class[] {String.class};
		Class<?> [] nullClassParameters = new Class[] {};
		Object[] stringParameters = new Object[] {ex.getMessage()};
		Object[] nullParameters = new Object[] {};
		
		Constructor<?> constructor = null;
		
		try {

			try {
				constructor = exceptionClass.getConstructor(stringClassParameters);
				return (RuntimeException) constructor.newInstance(stringParameters);
			} catch (NoSuchMethodException e1) {
				constructor = exceptionClass.getConstructor(nullClassParameters);
				return (RuntimeException) constructor.newInstance(nullParameters);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}
	
}
