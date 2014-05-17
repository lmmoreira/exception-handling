package br.exceptionhandlingweb.spring;

import org.exceptionhandling.context.ContextManager;
import org.exceptionhandling.delegation.ExceptionHandler;
import org.exceptionhandling.delegation.ExceptionWrapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware, ContextManager{

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }

    public Object getBean(Class<?> beanType) {
	return CONTEXT.getBean(beanType);
    }

	@Override
	public ExceptionHandler getExceptionHandler() {
		return (ExceptionHandler) this.getBean(ExceptionHandler.class);
	}

	@Override
	public ExceptionWrapper getExceptionWrapper() {
		return (ExceptionWrapper) this.getBean(ExceptionWrapper.class);
	}
}