package com.madhu.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
	
	public static void main(String[] args) {
		LOGGER.warn("Madhu");
		LOGGER.debug("Madhu");
		System.out.println("Madhu for syso");
		System.out.println(LOGGER.isDebugEnabled());
		LOGGER.debug("Madhu {} is working at {}", "prathap", "oracle", new Exception("exception"));
	}

}
