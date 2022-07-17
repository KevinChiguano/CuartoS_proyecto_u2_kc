package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

	@Override
	public List<Estudiante> buscarPorNombreDescNative(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE nombre = :datoNombre ORDER BY nombre DESC", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoDescNative(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE apellido = :datoApellido ORDER BY apellido DESC ", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadAscNamedNative(String edad) {
		// TODO Auto-generated method stub
		
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadAsc", Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoAscNamedNative(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreApellidoAsc", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> busquedaDinamicaCedulaCriteriaApi(String nombre, String apellido, String edad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
		
		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);
		
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		
		Predicate predicadoFinal = null;
		
		if(edad.equalsIgnoreCase("25")) {
			predicadoFinal = myCriteria.and(predicadoNombre,predicadoApellido);
		}else {
			predicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}
		
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		
		return myQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> busquedaDinamicaNombreCriteriaApi(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
		
		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);
		
		Predicate predicateCedula = myCriteria.equal(myTabla.get("cedula"), cedula);
		Predicate predicateNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicateApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		
		Predicate predicateAnd = myCriteria.and(predicateNombre,predicateApellido);
		Predicate predicateFinal = myCriteria.or(predicateAnd,predicateCedula);
		
		myQuery.select(myTabla).where(predicateFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		
		return myQueryFinal.getResultList();
	}

}
