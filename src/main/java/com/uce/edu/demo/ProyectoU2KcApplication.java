package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;
import com.uce.edu.demo.service.manytomany.IAutor2Service;
import com.uce.edu.demo.service.manytomany.ILibro2Service;
import com.uce.edu.demo.service.manytomany.ILibroAutorService;
import com.uce.edu.demo.service.manytomany.ILibroService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
		
	@Autowired
	private ILibroService libroService;
	
	@Autowired
	private ILibro2Service libro2Service;
	
	@Autowired
	private IAutor2Service autor2Service;
	
	@Autowired
	private ILibroAutorService libroAutorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		//Insertar autores
		Autor2 autor2 = new Autor2();
		autor2.setNombre("Juan");
		
		Autor2 autor21 = new Autor2();
		autor21.setNombre("Hugo");
		
		this.autor2Service.insertar(autor2);
		this.autor2Service.insertar(autor21);
		
		//Insertar libros
		Libro2 libro2 = new Libro2();
		libro2.setTitulo("Progamacion Web");
		libro2.setCantidadPaginas(500);
		
		Libro2 libro21 = new Libro2();
		libro21.setTitulo("Estructuras de datos");
		libro21.setCantidadPaginas(350);
		
		this.libro2Service.insertar(libro2);
		this.libro2Service.insertar(libro21);
		
		//1 libro que tiene dos autores
		Libro2 libro23 = new Libro2();
		libro23.setId(1);
		Autor2 autor23 = new Autor2();
		autor23.setId(1);
		Autor2 autor24 = new Autor2();
		autor24.setId(2);
		
		Libro2Autor2 libro2Autor2 = new Libro2Autor2();
		libro2Autor2.setAutor2(autor23);
		libro2Autor2.setLibro2(libro23);
		
		this.libroAutorService.insertar(libro2Autor2);
		
		Libro2Autor2 libro2Autor22 = new Libro2Autor2();
		libro2Autor22.setAutor2(autor24);
		libro2Autor22.setLibro2(libro23);
		
		this.libroAutorService.insertar(libro2Autor22);
		
		//1 autor que escribio dos libros
		Libro2 libro24 = new Libro2();
		libro24.setId(1);
		Libro2 libro25 = new Libro2();
		libro25.setId(2);
		Autor2 autor25 = new Autor2();
		autor25.setId(1);
		
		Libro2Autor2 libro2Autor24 = new Libro2Autor2();
		libro2Autor24.setAutor2(autor25);
		libro2Autor24.setLibro2(libro25);
		
		this.libroAutorService.insertar(libro2Autor24);
		
	}

}
