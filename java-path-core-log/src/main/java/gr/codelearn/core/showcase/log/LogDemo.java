package gr.codelearn.core.showcase.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {
	private static final Logger logger = LoggerFactory.getLogger(LogDemo.class);
	
	public static void main(String[] args) {
		String s1 = "Software";
		String s2 = "Engineer";
		logger.info("Hello {} -- {}",s1,s2);
		Exception ex = new RuntimeException("Ooops Error");
		logger.error("Something went wrong. Details: {}",ex.getMessage(),ex);
		
	}

}
