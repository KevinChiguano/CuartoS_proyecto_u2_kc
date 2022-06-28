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
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante estu = new Estudiante();
		estu.setId(1);
		estu.setNombre("Carlos");
		estu.setApellido("Zoila");
		estu.setCedula("123456789");
		estu.setEdad("20");
		
		//Insertar
		this.estudianteJdbcService.insertar(estu);
		
		Estudiante estu1 = new Estudiante();
		estu1.setId(2);
		estu1.setNombre("Carlos");
		estu1.setApellido("Zoila");
		estu1.setCedula("789456132");
		estu1.setEdad("21");
		
		//Actualizar
		this.estudianteJdbcService.actualizar(estu1);
		
		//Eliminar
		this.estudianteJdbcService.eliminar(1);
		
		//Buscar
		logger.info(this.estudianteJdbcService.buscar(2));
		
	}

}
