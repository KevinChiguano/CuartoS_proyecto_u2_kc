package com.uce.edu.demo.estudiante.to;

public class EstudianteTo {
	
	private int id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String edad;
	
	//Constructor por defecto
	public EstudianteTo() {
		
	}
	
	public EstudianteTo(int id, String nombre, String apellido, String cedula, String edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", edad=" + edad + "]";
	}
	//GET y SET
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
