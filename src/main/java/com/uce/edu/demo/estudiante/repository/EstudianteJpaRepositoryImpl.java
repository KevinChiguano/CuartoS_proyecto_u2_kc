package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estudiante = this.buscar(id);
		this.entityManager.remove(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorEdad(String edad) {
		// TODO Auto-generated method stub
		Query namedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad");
		namedQuery.setParameter("datoEdad", edad);
		return namedQuery.getResultList();
	}

	@Override
	public int eliminarPorEdad(String edad) {
		// TODO Auto-generated method stub
		Query namedQuery = this.entityManager.createNamedQuery("Estudiante.eliminarPorEdad");
		namedQuery.setParameter("datoEdad", edad);
		return namedQuery.executeUpdate();
	}

	@Override
	public List<Estudiante> buscarPorNombreAsc(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> tapedNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreAsc",Estudiante.class);
		tapedNamedQuery.setParameter("datoNombre", nombre);
		return tapedNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadDesc(String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> tapedNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadDesc",Estudiante.class);
		tapedNamedQuery.setParameter("datoEdad", edad);
		return tapedNamedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedula(String cedula, String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> typedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula AND e.nombre = :datoNombre",Estudiante.class);
		typedQuery.setParameter("datoCedula", cedula);
		typedQuery.setParameter("datoNombre", nombre);
		return typedQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedulaNombre(String cedula, String nombre, String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> typedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula =: datoCedula AND e.nombre =: datoNombre AND e.edad =: datoEdad",Estudiante.class);
		typedQuery.setParameter("datoEdad", edad);
		typedQuery.setParameter("datoCedula", cedula);
		typedQuery.setParameter("datoNombre", nombre);
		return typedQuery.getSingleResult();
	}

}
