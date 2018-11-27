package com.sita.fileapp.integration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationEntryPoint.class);
	

    public static void main(String[] args) throws InterruptedException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "fileProcessAppContext.xml");
        logger.info("Application is Running");
        try {  
            Thread.sleep(2000);
            while(true){}
        } finally {
            logger.info("Applciation is shutting down");
            context.close();
        }
    }
    
}

