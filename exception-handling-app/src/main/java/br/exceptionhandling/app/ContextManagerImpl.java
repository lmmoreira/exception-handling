package br.exceptionhandling.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exceptionhandling.context.ContextManager;
import org.exceptionhandling.delegation.DelegatingExceptionHandler;
import org.exceptionhandling.delegation.DelegatingExceptionWrapper;
import org.exceptionhandling.delegation.ExceptionHandler;
import org.exceptionhandling.delegation.ExceptionWrapper;
import org.exceptionhandling.handlers.AbstractHandler;

public class ContextManagerImpl implements ContextManager {

	Map<Class<?>, Object> beanContext = new HashMap<Class<?>, Object>();
	
	public ContextManagerImpl() {

		beanContext.put(ExceptionHandler.class, getExceptionHandlerBean());
		beanContext.put(ExceptionWrapper.class, getExceptionWrapperBean());
		
	}
	
	public ExceptionHandler getExceptionHandlerBean(){
	
		ExceptionHandler exceptionHandler = new ExceptionHandler();

		List<DelegatingExceptionHandler> delegationList = new ArrayList<DelegatingExceptionHandler>();
		List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
		handlers.add(new MyHandler());

		DelegatingExceptionHandler h1 = new DelegatingExceptionHandler();
		h1.setException(new IllegalArgumentException());
		h1.setHandlers(handlers);

		DelegatingExceptionHandler h2 = new DelegatingExceptionHandler();
		h2.setException(new IndexOutOfBoundsException());
		h2.setHandlers(handlers);
		
		DelegatingExceptionHandler h3 = new DelegatingExceptionHandler();
		h3.setException(new ExcecaoAritimetica());
		h3.setHandlers(handlers);

		delegationList.add(h1);
		delegationList.add(h2);
		delegationList.add(h3);
		exceptionHandler.setExceptionHandlers(delegationList);
		
		return exceptionHandler;
		
	}

	public ExceptionWrapper getExceptionWrapperBean(){
		
		ExceptionWrapper exceptionWrapper = new ExceptionWrapper();

		List<DelegatingExceptionWrapper> delegationList = new ArrayList<DelegatingExceptionWrapper>();
		
		DelegatingExceptionWrapper d1 = new DelegatingExceptionWrapper();
		d1.setFrom(new ArithmeticException());
		d1.setTo(new ExcecaoAritimetica());
		
		DelegatingExceptionWrapper d2 = new DelegatingExceptionWrapper();
		d2.setFrom(new ArrayStoreException());
		d2.setTo(new ExcecaoArmazenamentoEmArray());
		
		delegationList.add(d1);
		delegationList.add(d2);
		exceptionWrapper.setExceptionWrappers(delegationList);
		return exceptionWrapper;
		
	}

	public ExceptionHandler getExceptionHandler() {
		return (ExceptionHandler) beanContext.get(ExceptionHandler.class);
	}

	public ExceptionWrapper getExceptionWrapper() {
		return (ExceptionWrapper) beanContext.get(ExceptionWrapper.class);
	}

}
