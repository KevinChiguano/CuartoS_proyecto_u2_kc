package com.uce.edu.demo.service.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.manytomany.ILibroAutorRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;

@Service
public class LibroAutorServiceImpl implements ILibroAutorService{

	@Autowired
	private ILibroAutorRepository libroAutorRepository;
	
	@Override
	public void insertar(Libro2Autor2 libroAutor) {
		// TODO Auto-generated method stub
		this.libroAutorRepository.insertar(libroAutor);
	}

}
