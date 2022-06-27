package com.uce.edu.demo;

import org.apache.log4j.spi.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.tools.javac.Main;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static Logger logger = Logger.getLogger(ProyectoU2KcApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Hola");
		logger.error("Hola error");
	}

}
