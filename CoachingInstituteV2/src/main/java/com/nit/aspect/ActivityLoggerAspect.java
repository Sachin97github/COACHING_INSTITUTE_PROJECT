package com.nit.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;

public class ActivityLoggerAspect {
	
	private static Logger logger=Logger.getLogger(ActivityLoggerAspect.class);

	/*
	 * static { PropertyConfigurator.configure(
	 * "src/main/java/com/nit/commons/log4j.properties"); }
	 */
	public void logger(JoinPoint jp)
	{
		System.out.println("Function :: "+jp.getSignature().getName()+" with Args [ "+Arrays.toString(jp.getArgs())+" ]");
		 logger.info("Function :: "+jp.getSignature().getName()+" with Args [ "+Arrays.toString(jp.getArgs())+" ]");		
	}

}
