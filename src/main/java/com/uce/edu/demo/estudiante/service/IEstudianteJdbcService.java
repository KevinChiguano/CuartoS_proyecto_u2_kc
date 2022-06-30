package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcService {

	public void insertar(EstudianteTo estudiante);

	public EstudianteTo buscar(int id);

	public void actualizar(EstudianteTo estudiante);

	public void eliminar(int id);

}
