package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Persona;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//Buscar
		logger.info("Datos con JPA: "+this.estudianteJpaService.buscar(2));
		
		Estudiante estu = new Estudiante();
		estu.setId(1);
		estu.setNombre("Alonso");
		estu.setApellido("Aguilar");
		estu.setCedula("456789132");
		estu.setEdad("26");
		
		//Guardar
		this.estudianteJpaService.insertar(estu);
		
		Estudiante estu1 = new Estudiante();
		estu1.setId(2);
		estu1.setNombre("Alonso");
		estu1.setApellido("Aguilar");
		estu1.setCedula("147852396");
		estu1.setEdad("24");
		
		//Actualizacion
		this.estudianteJpaService.actualizar(estu1);
		
		//Borrar
		this.estudianteJpaService.eliminar(1);
	}

}
