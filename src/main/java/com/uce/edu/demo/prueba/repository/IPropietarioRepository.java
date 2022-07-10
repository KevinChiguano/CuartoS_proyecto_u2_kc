package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioRepository {

	public void crear(Propietario propietario);
	
	public void eliminar(String cedula);
	
	public Propietario consultar(String cedula);
	
	
}
