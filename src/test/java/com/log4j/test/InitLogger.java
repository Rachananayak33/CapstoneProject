package com.log4j.test;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class InitLogger {
	Logger logger;
	public InitLogger(Class<TestRestAssured> class1) {	
		logger=Logger.getLogger(class1);
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	public InitLogger(String name) {
		logger = LogManager.getLogger(name);
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	public void LogInfo(String message) {
		logger.info(message);
	}
	public void LogDebug(String message) {
		logger.debug(message);
		System.out.println("Added to debug");
	}
	public void LogWarn(String message) {
		logger.warn(message);
	}
}


