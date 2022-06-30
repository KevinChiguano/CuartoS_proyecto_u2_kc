package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;


public interface IEstudianteJpaRepository {
	public void insertar(Estudiante estudiante);

	public Estudiante buscar(Integer id);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
}
