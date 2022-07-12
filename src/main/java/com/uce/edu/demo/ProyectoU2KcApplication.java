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
		
		Estudiante estudiante = new Estudiante();
		estudiante.setApellido("Chiguano");
		estudiante.setNombre("Kevin");
		estudiante.setCedula("102352698");
		estudiante.setEdad("30");
		//this.estudianteJpaService.insertar(estudiante);
		
		//NamedQuery
		LOGGER.info(this.estudianteJpaService.buscarPorEdad("25"));
		
		//NamedQuery
		LOGGER.info(this.estudianteJpaService.eliminarPorEdad("30"));
		
		//TypedQuery NamedQuery
		LOGGER.info(this.estudianteJpaService.buscarPorNombreAsc("Juan"));
		
		//TypedQuery NamedQuery
		LOGGER.info(this.estudianteJpaService.buscarPorEdadDesc("25"));
		
		//Typed
		LOGGER.info(this.estudianteJpaService.buscarPorCedula("123789456", "Juan"));
		
		//Typed
		LOGGER.info(this.estudianteJpaService.buscarPorCedulaNombre("439521678", "Maria", "25"));
		
	}

}
