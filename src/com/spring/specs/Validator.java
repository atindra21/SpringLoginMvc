package com.spring.specs;

import org.apache.log4j.Logger;
import com.spring.bean.Message;

public class Validator {

	static Logger log = Logger.getLogger(Validator.class);
	
	public static boolean isValidMessage(Message m) 
	{
		String name = m.getName();
		String message = m.getMessage();
		
		if (name == "" || message == "") 
		{
			log.info("invalid message entry");
			return false;
		} 
		else 
		{
			log.info("valid message entry");
			return true;
		}
	}
}
