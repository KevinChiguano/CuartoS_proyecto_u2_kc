package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setApellido("Cayambe");
		ciudadano.setNombre("David");
		
		Empleado empl1 = new Empleado();
		empl1.setCodigoIess("456456");
		empl1.setSalario(new BigDecimal(200));
		empl1.setCiudadano(ciudadano);
		
		ciudadano.setEmpleado(empl1);
		
		this.ciudadanoService.insertar(ciudadano);
		
		Ciudadano ciudadano2 = new Ciudadano();
		ciudadano2.setApellido("Cayambe2");
		ciudadano2.setNombre("David2");
		
		Empleado empl2 = new Empleado();
		empl2.setCodigoIess("456456");
		empl2.setSalario(new BigDecimal(202));
		empl2.setCiudadano(ciudadano);
		
		//ciudadano.setEmpleado(empl1);
		
	}

}
