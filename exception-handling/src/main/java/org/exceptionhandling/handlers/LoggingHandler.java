package org.exceptionhandling.handlers;

import java.util.logging.Logger;

public class LoggingHandler extends AbstractHandler {

	Logger log = Logger.getLogger("log");

	@Override
	public void handle(Exception ex) {
		log.severe(ex.getMessage());
	}

}
