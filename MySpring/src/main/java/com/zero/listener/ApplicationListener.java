package com.zero.listener;

import javax.servlet.ServletContextEvent ;
import javax.servlet.ServletContextListener ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

public class ApplicationListener implements ServletContextListener{
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("ApplicationListener init....");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("ApplicationListener destroy....");
	}
	
}
