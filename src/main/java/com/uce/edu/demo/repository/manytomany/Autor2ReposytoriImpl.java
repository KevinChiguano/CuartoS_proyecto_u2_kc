package com.uce.edu.demo.repository.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Autor2;

@Repository
@Transactional
public class Autor2ReposytoriImpl implements IAutor2Repository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor2);
	}

}
