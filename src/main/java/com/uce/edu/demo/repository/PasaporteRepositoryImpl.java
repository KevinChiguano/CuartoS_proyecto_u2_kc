package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetoone.Pasaporte;

@Repository
@Transactional
public class PasaporteRepositoryImpl implements IPasaporteRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void insertar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.entityManager.persist(pasaporte);
	}

	@Override
	public Pasaporte buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Pasaporte.class, id);
	}

	@Override
	public void actualizar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.entityManager.merge(pasaporte);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Pasaporte pasaporte = new Pasaporte();
		pasaporte = this.buscar(id);
		this.entityManager.remove(pasaporte);
	}

}
