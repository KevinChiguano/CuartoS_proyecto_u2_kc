package com.uce.edu.demo.repository.modelo.manytomany;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro2_autor2")
public class Libro2Autor2 implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "liau_id_libro")
	private Libro2 libro2;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "liau_id_autor")
	private Autor2 autor2;


	//SET y GET
	public Libro2 getLibro2() {
		return libro2;
	}


	public void setLibro2(Libro2 libro2) {
		this.libro2 = libro2;
	}


	public Autor2 getAutor2() {
		return autor2;
	}


	public void setAutor2(Autor2 autor2) {
		this.autor2 = autor2;
	}
	
	


}
	
