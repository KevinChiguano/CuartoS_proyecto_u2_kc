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
	private IPersonaJpaService iPersonaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Actualizar con JPQL
		//int resultado = this.iPersonaJpaService.actualizarPorApellido("FE", "Perez");
		//LOGGER.info("Cantidad de registros actualizados: "+resultado);
		
		//Eliminar con JPQL
		int resultado2 = this.iPersonaJpaService.eliminarPorGenero("F");
		LOGGER.info("Cantidad de eliminados: "+ resultado2);
	}

}
