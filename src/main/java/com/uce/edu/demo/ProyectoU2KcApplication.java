package com.uce.edu.demo;

import org.apache.log4j.spi.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.tools.javac.Main;
import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.to.PersonaTo;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//logger.info("Lista: "+this.iPersonaJdbcService.buscarTodos());
		
		//Buscar
		logger.info("Datos con JPA: "+this.iPersonaJpaService.buscarPorId(2));
		Persona per = new Persona();
		per.setId(7);
		per.setNombre("Edison");
		per.setApellido("Benabides");
		
		//Guardar
		//this.iPersonaJpaService.guardar(per);
		
		Persona per1 = new Persona();
		per1.setId(4);
		per1.setNombre("Andrea");
		per1.setApellido("Solis");
		
		//Actualizacion
		//this.iPersonaJpaService.actualizar(per1);
		
		//Borrar
		this.iPersonaJpaService.eliminar(1);
	}

}
