package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Persona per = new Persona();
		per.setNombre("Daniel");
		per.setApellido("Velez");
		per.setGenero("M");
		per.setCedula("345345");
		
		this.iPersonaJpaService.guardar(per);
		
		//1 TypedQuery
		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaTyped("123123123");
		LOGGER.info("Persona Typed: "+perTyped);
		//2 NamedQuery
		Persona perNamed = this.iPersonaJpaService.buscarPorCedulaNamed("123123123");
		LOGGER.info("Persona Named: "+perNamed);
		//3 TypedQuery NamedQuery
		Persona perTypedNamed = this.iPersonaJpaService.buscarPorCedulaTypedNamed("123123123");
		LOGGER.info("Persona NamedTyped: "+perTypedNamed);
		
		//4. Varios NamedQuery
		List<Persona> listaPersona = this.iPersonaJpaService.buscarPorNombreApellido("Daniel", "Velez");
		for(Persona item:listaPersona) {
			LOGGER.info("Persona: "+item);
		}
		
	}

}
