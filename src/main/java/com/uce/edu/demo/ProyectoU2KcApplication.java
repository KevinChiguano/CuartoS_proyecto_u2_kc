package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//Buscar
		//LOGGER.info("Datos con JPA: "+this.iPersonaJpaService.buscarPorId(2));
		
		Persona per = new Persona();
		//per.setId(6);
		per.setNombre("Juan");
		per.setApellido("Chiguano");
		per.setGenero("M");
		per.setCedula("987451296");
		
		//Guardar
		//this.iPersonaJpaService.guardar(per);
		
		Persona per1 = new Persona();
		per1.setId(6);
		per1.setNombre("Kevin");
		per1.setApellido("Correa");
		
		//Actualizacion
		//this.iPersonaJpaService.actualizar(per1);
		
		//Borrar
		//this.iPersonaJpaService.eliminar(7);
		
		//Buscar por cedula
		//Persona p = this.iPersonaJpaService.buscarPorCedula("123456789");
		//LOGGER.info("Persona encontrada: "+p);
		
		//Buscar por apellido
		List<Persona> listaPersona = this.iPersonaJpaService.buscarPorApellido("Perez");
		
		for(Persona item: listaPersona) {
			LOGGER.info("Persona: "+item);
		}
	}

}
