package com.uce.edu.demo;

import org.apache.log4j.spi.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.tools.javac.Main;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setId(4);
		persona.setNombre("Alexx");
		persona.setApellido("Guaman");
		
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		Persona per1 = new Persona();
		per1.setId(1);
		per1.setNombre("A");
		per1.setApellido("B");
		
		//Actualizar
		//this.iPersonaJdbcService.actualizar(per1);
		
		//Eliminar
		//this.iPersonaJdbcService.eliminar(3);
		
		//Buscar
		logger.info(this.iPersonaJdbcService.buscar(4));
		
	}

}
