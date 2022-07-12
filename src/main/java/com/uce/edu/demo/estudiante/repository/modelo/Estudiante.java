package com.uce.edu.demo.estudiante.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "estudiante")
@Entity
@NamedQuery(name = "Estudiante.buscarPorEdad",query = "SELECT e FROM Estudiante e WHERE e.edad = :datoEdad")
@NamedQuery(name = "Estudiante.eliminarPorEdad",query = "DELETE FROM Estudiante e WHERE e.edad = :datoEdad")
@NamedQuery(name = "Estudiante.buscarPorNombreAsc",query = "SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre ORDER BY e.apellido ASC")
@NamedQuery(name = "Estudiante.buscarPorEdadDesc",query = "SELECT e FROM Estudiante e WHERE e.edad = :datoEdad ORDER BY e.nombre DESC")
public class Estudiante {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq")
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "cedula")
	private String cedula;

	@Column(name = "edad")
	private String edad;

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", edad="
				+ edad + "]";
	}

	// GET y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

}
