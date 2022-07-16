package com.uce.edu.demo.repository;

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

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// black Friday se inserta
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		// SELECT * FROM public.persona where pers_cedula='Perez'
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Persona) jpqlQuery.getSingleResult();

	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona Where pers_cedula = :datoCedula",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return  (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		//Creamos una instancia de la interfaz CriteriaBuilder Fabrica para construir el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		//Especificamos el retorno de mi SQL 
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);

		//Aqui empezamos a construir el SQL
		// Root FROM -> tabla principal
		
		Root<Persona> personaFrom = myQuery.from(Persona.class); //FROM Persona
		//myQuery.select(personaFrom);//Select p FROM Persona
		//Las condiciones where en criteria API se los conoce como predicados
		Predicate p1 =  myBuilder.equal(personaFrom.get("cedula"), cedula); //Esta representando p.cedula = :datoCedula
		
		CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaFrom).where(p1);
		//myQuery.select(personaFrom).where(p1);
		
		//Finalizado mi query completo
		
		//CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaRoot).where(myBuilder.equal(personaRoot.get("cedula"), cedula));
		TypedQuery<Persona> myQueryFinal =this.entityManager.createQuery(myQueryCompleto);

		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery =myCriteria.createQuery(Persona.class);
		
		Root<Persona> myTabla = myQuery.from(Persona.class);
		
		//pers_nombre = 'Diana'
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		//pers_apellido = 'Muñoz'
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		//pers_nombre = 'Diana' and pers_apellido = 'Mu'
		
		
		Predicate predicadoFinal = null;
		
		
		if(genero.equals("M")) {
			predicadoFinal =  myCriteria.and(predicadoNombre, predicadoApellido);
		}else {
			predicadoFinal  = myCriteria.or(predicadoNombre,predicadoApellido);
		}
		
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<Persona> myQueryFinal =this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery =myCriteria.createQuery(Persona.class);
		
		Root<Persona> myTabla = myQuery.from(Persona.class);
		
		//pers_nombre = 'Diana'
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		//pers_apellido = 'Muñoz'
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		//pers_nombre = 'Diana' and pers_apellido = 'Mu'
		
		Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);
		
		Predicate predicadoFinal = null;
		
		
		if(genero.equals("M")) {
			predicadoFinal =  myCriteria.or(predicadoNombre, predicadoApellido);
			predicadoFinal = myCriteria.and(predicadoFinal,predicadoGenero);
		}else {
			predicadoFinal  = myCriteria.or(predicadoNombre,predicadoApellido, predicadoGenero);
			predicadoFinal = myCriteria.and(predicadoFinal,predicadoGenero);
		}
		
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<Persona> myQueryFinal =this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		// delete from persona where pers_apellido = 'Perez'
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero= :genero");
		myQuery.setParameter("genero", genero);
		return myQuery.executeUpdate();
	}

	

}
