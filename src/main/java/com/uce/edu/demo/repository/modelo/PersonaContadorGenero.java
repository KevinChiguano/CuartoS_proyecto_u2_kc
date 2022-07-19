package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class PersonaContadorGenero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String genero;
	private Long numero;

	public PersonaContadorGenero() {

	}

	public PersonaContadorGenero(String genero, Long numero) {
		this.genero = genero;
		this.numero = numero;
	}
	
	

	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", numero=" + numero + "]";
	}

	//SET y GET
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

}
