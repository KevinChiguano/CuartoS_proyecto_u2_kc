package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano1;

@Repository
@Transactional
public class Ciudadano1RepositoryImpl implements ICiudadano1Repository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ciudadano1 ciudadano1) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano1);
	}

	@Override
	public Ciudadano1 buscar(Integer id) {
		// TODO Auto-generated method stub
		
		
		//Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano1 c JOIN pasaporte p ON c.ciud1_id = p.ciud1_id_ciudadano where c.ciud1_id = :datoId", Ciudadano1.class);
		
		//myQuery.setParameter("datoId", id);
		
		Query myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano1 c WHERE id =: datoId");
		myQuery.setParameter("datoId", id);
		return (Ciudadano1) myQuery.getSingleResult();
		//return this.entityManager.find(Ciudadano1.class, id);
	}

	@Override
	public void actualizar(Ciudadano1 ciudadano1) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano1);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano1 ciudadano1 = new Ciudadano1();
		ciudadano1 = this.buscar(id);
		this.entityManager.remove(ciudadano1);
	}

}
