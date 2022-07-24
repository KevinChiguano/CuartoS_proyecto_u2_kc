package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Autor;
import com.uce.edu.demo.repository.modelo.onetomany.Libro;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor autor = new Autor();
		autor = this.buscar(id);
		this.entityManager.remove(autor);
	}

	@Override
	public List<Libro> buscarAutorLibro(Integer id) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * from libro WHERE libr_id_autor = :datoId",Libro.class);
		myQuery.setParameter("datoId", id);
		return myQuery.getResultList();
	}

}
