package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{

	@Autowired
	IEstudianteJpaRepository estudianteJpaRepository;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> buscarPorEdad(String edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdad(edad);
	}

	@Override
	public int eliminarPorEdad(String edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.eliminarPorEdad(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreAsc(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreAsc(nombre);
	}

	@Override
	public List<Estudiante> buscarPorEdadDesc(String edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdadDesc(edad);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula, String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedula(cedula, nombre);
	}

	@Override
	public Estudiante buscarPorCedulaNombre(String cedula, String nombre, String edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaNombre(cedula, nombre, edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreDescNative(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreDescNative(nombre);
	}

	@Override
	public List<Estudiante> buscarPorApellidoDescNative(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorApellidoDescNative(apellido);
	}

	@Override
	public List<Estudiante> buscarPorEdadAscNamedNative(String edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdadAscNamedNative(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoAscNamedNative(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreApellidoAscNamedNative(nombre, apellido);
	}

	@Override
	public List<Estudiante> busquedaDinamicaCedulaCriteriaApi(String nombre, String apellido, String edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.busquedaDinamicaCedulaCriteriaApi(nombre, apellido, edad);
	}

	@Override
	public List<Estudiante> busquedaDinamicaNombreCriteriaApi(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.busquedaDinamicaNombreCriteriaApi(nombre, apellido, cedula);
	}

	@Override
	public EstudianteSencillo buscarPorCedulaSencillo(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaSencillo(cedula);
	}

	@Override
	public List<EstudianteContadorEdad> consultarCantidadPorEdad() {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.consultarCantidadPorEdad();
	}

}
