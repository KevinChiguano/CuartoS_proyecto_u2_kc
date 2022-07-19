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
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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
		
		Persona p1 = new Persona();
		p1.setApellido("Aragon");
		p1.setNombre("Dayana");
		p1.setGenero("F");
		//this.iPersonaJpaService.guardar(p1);
		
//		List<PersonaSencilla> listaPersona = this.iPersonaJpaService.buscarPorApellidoSencillo("Correa");
//		
//		for(PersonaSencilla perItem: listaPersona) {
//			LOGGER.info("Persona Sencilla: "+perItem);
//		}
		
		List<PersonaContadorGenero> miListaPersonaGenero = iPersonaJpaService.consultarCantidadPorGenero();
		
		for(PersonaContadorGenero item: miListaPersonaGenero) {
			LOGGER.info("Genero: "+item);
		}
		
	}

}
