package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public void insertar(Estudiante estudiante);

	public Estudiante buscar(int id);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int id);

}
