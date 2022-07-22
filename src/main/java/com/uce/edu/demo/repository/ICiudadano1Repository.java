package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Ciudadano1;

public interface ICiudadano1Repository {
	
	public void insertar(Ciudadano1 ciudadano1);
	public Ciudadano1 buscar(Integer id);
	public void actualizar(Ciudadano1 ciudadano1);
	public void eliminar(Integer id);

}
