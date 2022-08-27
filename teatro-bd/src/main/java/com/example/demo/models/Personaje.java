package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAJE")
public class Personaje {

	@Id
	@Column(name = "IDPERSONAJE", nullable = false)
	private String idPersonaje;
	@Column(name = "IDOBRA", nullable = false)
	private String idObra;	
	@Column(name = "NOMPERSONAJE", nullable = false)
	private String nomPersonaje;

	public String getIdObra() {
		return idObra;
	}

	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}

	public String getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(String idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNomPersonaje() {
		return nomPersonaje;
	}

	public void setNomPersonaje(String nomPersonaje) {
		this.nomPersonaje = nomPersonaje;
	}

}
