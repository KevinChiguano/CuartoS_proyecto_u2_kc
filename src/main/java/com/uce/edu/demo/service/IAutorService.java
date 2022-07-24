package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.onetomany.Autor;
import com.uce.edu.demo.repository.modelo.onetomany.Libro;

public interface IAutorService {
	
	public void insertar(Autor autor);
	public Autor buscar(Integer id);
	public void actualizar(Autor autor);
	public void eliminar(Integer id);
	public List<Libro> buscarAutorLibro(Integer id);

}
