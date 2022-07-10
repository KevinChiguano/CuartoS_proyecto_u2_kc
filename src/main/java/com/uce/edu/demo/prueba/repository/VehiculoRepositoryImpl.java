package com.uce.edu.demo.prueba.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("DELETE FROM Vehiculo v WHERE v.placa =:datoPlaca");
		query.setParameter("datoPlaca", placa);
		query.executeUpdate();
		
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa =: datoPlaca");
		query.setParameter("datoPlaca", placa);
		return (Vehiculo)query.getSingleResult();
	}

}
