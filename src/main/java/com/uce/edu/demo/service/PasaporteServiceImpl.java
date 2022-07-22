package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPasaporteRepository;
import com.uce.edu.demo.repository.modelo.Pasaporte;

@Service
public class PasaporteServiceImpl implements IPasaporteService{

	@Autowired
	private IPasaporteRepository iPasaporteRepository;
	
	@Override
	public void insertar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.iPasaporteRepository.insertar(pasaporte);
	}

	@Override
	public Pasaporte buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPasaporteRepository.buscar(id);
	}

	@Override
	public void actualizar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.iPasaporteRepository.actualizar(pasaporte);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPasaporteRepository.eliminar(id);
	}

}
