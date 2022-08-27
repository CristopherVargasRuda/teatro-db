package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOUNIDAD")
public class TipoUnidad {

	@Id
	@Column(name = "TIPOUNIDAD", nullable = false)
	private String tipoUnidad;
	@Column(name = "DESCTIPOUNI", nullable = false)
	private String descTipoUni;

	public String getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public String getDescTipoUni() {
		return descTipoUni;
	}

	public void setDescTipoUni(String descTipoUni) {
		this.descTipoUni = descTipoUni;
	}

}
