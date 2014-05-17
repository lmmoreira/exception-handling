package org.exceptionhandling.aop;

import org.exceptionhandling.wrap.ExceptionWrap;

public aspect ExceptionWrapInterceptor {

	ExceptionWrap wrapper = new ExceptionWrap();
	
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
			return wrapper.wrap(ex);
		}
	}

}
