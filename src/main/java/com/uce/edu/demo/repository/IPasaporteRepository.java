package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Pasaporte;

public interface IPasaporteRepository {
	
	public void insertar(Pasaporte pasaporte);
	public Pasaporte buscar(Integer id);
	public void actualizar(Pasaporte pasaporte);
	public void eliminar(Integer id);

}
