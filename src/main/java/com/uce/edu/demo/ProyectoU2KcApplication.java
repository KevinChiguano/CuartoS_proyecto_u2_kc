package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.manytomany.ILibroService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
		
	@Autowired
	private ILibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Autor autor1 = new Autor();
		autor1.setNombre("Juan Perez 3");
		
		Autor autor2 = new Autor();
		autor2.setNombre("Juan Perez 4");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(autor1);
		autores.add(autor2);
		
		Libro libro = new Libro();
		libro.setTitulo("Progamacion Web");
		libro.setCantidadPaginas(10);
		
		libro.setAutores(autores);
		
		this.libroService.insertar(libro);
		
	}

}
