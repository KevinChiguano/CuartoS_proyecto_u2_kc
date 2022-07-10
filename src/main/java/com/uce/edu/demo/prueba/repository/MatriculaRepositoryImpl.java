package com.uce.edu.demo.prueba.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@Override
	public void crear(Matricula matricula) {
		// TODO Auto-generated method stub
		System.out.println("Se crea la matricula: "+matricula);
	}

	

}
