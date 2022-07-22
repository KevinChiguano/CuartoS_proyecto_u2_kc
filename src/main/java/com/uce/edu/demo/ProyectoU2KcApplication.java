package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano1;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.Ciudadano1ServiceImpl;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private Ciudadano1ServiceImpl ciudadano1ServiceImpl;
	
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano1 ciudadano1 = new Ciudadano1();
		ciudadano1.setNombre("Daniel");
		ciudadano1.setApellido("Pozo");
		ciudadano1.setCedula("1593578642");
		ciudadano1.setFechaNacimiento(LocalDateTime.of(2001, 10, 10, 9, 10));
		
		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero("123452489");
		pasaporte.setFechaEmision(LocalDateTime.of(2021, 8, 4, 9, 9));
		pasaporte.setFechaCaducidad(LocalDateTime.of(2028, 3, 9, 10, 10));
		pasaporte.setCiudadano1(ciudadano1);
		
		
		ciudadano1.setPasaporte(pasaporte);
		//insertar
		this.ciudadano1ServiceImpl.insertar(ciudadano1);
		//eliminar
		this.ciudadano1ServiceImpl.eliminar(7);
		
		ciudadano1.setNombre("Juan");
		ciudadano1.setApellido("Arguello");
		ciudadano1.setCedula("1593578642");
		ciudadano1.setFechaNacimiento(LocalDateTime.of(2001, 10, 10, 9, 10));
		
		pasaporte.setNumero("123452489");
		pasaporte.setFechaEmision(LocalDateTime.of(2022, 8, 4, 9, 9));
		pasaporte.setFechaCaducidad(LocalDateTime.of(2030, 3, 9, 10, 10));
		pasaporte.setCiudadano1(ciudadano1);
		
		
		ciudadano1.setPasaporte(pasaporte);
		
		ciudadano1.setId(9);
		pasaporte.setId(10);
		
		ciudadano1.setPasaporte(pasaporte);
		
		//actualizar
		this.ciudadano1ServiceImpl.actualizar(ciudadano1);
		
		//buscar
		LOGGER.info(this.ciudadano1ServiceImpl.buscar(10));
		
	}

}
