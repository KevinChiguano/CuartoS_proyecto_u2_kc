package com.uce.edu.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Autor;
import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.repository.modelo.onetomany.Libro;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano1;
import com.uce.edu.demo.repository.modelo.onetoone.Pasaporte;
import com.uce.edu.demo.service.Ciudadano1ServiceImpl;
import com.uce.edu.demo.service.IAutorService;
import com.uce.edu.demo.service.ICiudadano1Service;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private ICiudadano1Service ciudadano1Service;
	
	@Autowired
	private IAutorService autorService;
	
	@Autowired
	private ILibroService libroService;
	
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Hotel hotel2 = new Hotel();
		hotel2.setNombre("Hilton Colon GUY");
		hotel2.setDireccion("Malecon");

		hotelService.insertar(hotel2);*/
		
		//Buscar numero
//		Hotel hote = new Hotel();
//		hote.setId(1);
//		
//		Habitacion habi1 = new Habitacion();
//		habi1.setNumero("A234");
//		habi1.setPiso("10");
//		habi1.setTipo("Familiar");
//		habi1.setHotel(hote);
//		
//		Habitacion habi2 = new Habitacion();
//		habi2.setNumero("1231223");
//		habi2.setPiso("1");
//		habi2.setTipo("Matrimonial");
//		habi2.setHotel(hote);
//		
//		this.habitacionService.insertar(habi1);
//		this.habitacionService.insertar(habi2);
		
		//this.ciudadano1Service.eliminar(8);
		//Ciudadano1 ciudadano1 = this.ciudadano1Service.buscar(9);
		//LOGGER.info(ciudadano1.getPasaporte()+"\n"+ciudadano1.toString());
		//LOGGER.info("Ciudadano: "+this.ciudadano1Service.buscar(9));
		//System.out.println(this.ciudadano1Service.buscar(9));
		
		//Insertar
		Autor autor1 = new Autor();
		autor1.setNombre("Fausto");
		autor1.setApellido("Rosmarie");	
		this.autorService.insertar(autor1);
		
		Autor autorL = new Autor();
		autorL.setId(3);
		
		Libro libro1 = new Libro();
		libro1.setTitulo("To lover Ru");
		libro1.setIsbn("15489413216");
		libro1.setGenero("Comedia");
		
		Libro libro2 = new Libro();
		libro2.setTitulo("Fate Grand Order");
		libro2.setIsbn("1254358");
		libro2.setGenero("Hitorico");
		
		libro1.setAutor(autorL);
		libro2.setAutor(autorL);
		this.libroService.insertar(libro1);
		this.libroService.insertar(libro2);
		
		//Eliminar
		this.autorService.eliminar(1);
		
		//Actualizar
		Autor autor2 = new Autor();
		autor2.setId(2);
		autor2.setNombre("Orion");
		autor2.setApellido("Blade");
		this.autorService.actualizar(autor2);
		
		//Buscar
		Autor autor3 = new Autor();
		autor3 = this.autorService.buscar(2);
		LOGGER.info("Autor: "+autor3.toString());
		LOGGER.info("Libros"+this.autorService.buscarAutorLibro(2));
		
	}

}
