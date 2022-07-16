package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//NaviteQuery
		//LOGGER.info(this.estudianteJpaService.buscarPorApellidoDescNative("Veloz"));
		//LOGGER.info(this.estudianteJpaService.buscarPorNombreDescNative("Maria"));
		
		//NamedNativeQuery
		//LOGGER.info(this.estudianteJpaService.buscarPorEdadAscNamedNative("25"));
		//LOGGER.info(this.estudianteJpaService.buscarPorNombreApellidoAscNamedNative("Juan", "Veloz"));
		
		//Persona perTyped = this.iPersonaJpaService.buscarPorCedulaCriteriaApi("345345");
		
		//LOGGER.info("Persona Criteria API: "+ perTyped);
		
		Persona perDinamica = this.iPersonaJpaService.buscarDinamicamente("Daniela", "Perez", "F");
		LOGGER.info(perDinamica);
	}

}
