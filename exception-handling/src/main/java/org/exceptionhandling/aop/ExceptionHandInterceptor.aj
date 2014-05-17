package org.exceptionhandling.aop;

import org.exceptionhandling.handle.ExceptionHandle;

public aspect ExceptionHandInterceptor {

	ExceptionHandle handler = new ExceptionHandle();
	
	pointcut handlers ():  within(!org.exceptionhandling..*) &&
						   within(!sun..*) &&	
						   within(!java..*) &&
						   within(!javax..*) &&
						   within(!org.apache..*) &&
						   within(!net.sf.cglib..*) &&
						   within(!org.ajax4jsf..*) &&
						   within(!org.richfaces..*) &&
						   within(!com.sun..*) &&
						   within(!org.springframework..*);
	
	Object around() : handlers()  {
		try {
			return proceed();
		} catch (RuntimeException ex) {
			return handler.handle(ex);
		}
	}

}
