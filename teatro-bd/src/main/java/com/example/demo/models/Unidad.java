package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIDAD")
public class Unidad {

	@Id
	@Column(name = "CODUNIDAD", nullable = false)
	private String codUnidad;
	@Column(name = "TIPOUNIDAD", nullable = false)
	private String tipoUnidad;
	@Column(name = "UNI_CODUNIDAD", nullable = true)
	private String uni_codUnidad;
	@Column(name = "NOMUNIDAD", nullable = false)
	private String nomUnidad;

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public String getUni_codUnidad() {
		return uni_codUnidad;
	}

	public void setUni_codUnidad(String uni_codUnidad) {
		this.uni_codUnidad = uni_codUnidad;
	}

	public String getNomUnidad() {
		return nomUnidad;
	}

	public void setNomUnidad(String nomUnidad) {
		this.nomUnidad = nomUnidad;
	}

}
