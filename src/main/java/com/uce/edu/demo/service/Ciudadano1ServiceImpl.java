package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadano1Repository;
import com.uce.edu.demo.repository.modelo.Ciudadano1;

@Service
public class Ciudadano1ServiceImpl implements ICiudadano1Service{

	@Autowired
	private ICiudadano1Repository ciudadano1Repository;
	
	@Override
	public void insertar(Ciudadano1 ciudadano1) {
		// TODO Auto-generated method stub
		this.ciudadano1Repository.insertar(ciudadano1);
	}

	@Override
	public Ciudadano1 buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadano1Repository.buscar(id);
	}

	@Override
	public void actualizar(Ciudadano1 ciudadano1) {
		// TODO Auto-generated method stub
		this.ciudadano1Repository.actualizar(ciudadano1);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadano1Repository.eliminar(id);
	}

}
