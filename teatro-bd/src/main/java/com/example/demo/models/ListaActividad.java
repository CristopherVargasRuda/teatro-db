package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LISTAACTIVIDAD")
public class ListaActividad {

	@Id
	@Column(name = "IDPERIODO", nullable = false)
	private long idPeriodo;
	@Column(name = "CODACTIVIDAD", nullable = false)
	private String codActividad;
	@Column(name = "DESCACTIVIDAD", nullable = false)
	private long descActividad;
	@Column(name = "VALORHORA", nullable = false)
	private long valorHora;

	public long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getCodActividad() {
		return codActividad;
	}

	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}

	public long getDescActividad() {
		return descActividad;
	}

	public void setDescActividad(long descActividad) {
		this.descActividad = descActividad;
	}

	public long getValorHora() {
		return valorHora;
	}

	public void setValorHora(long valorHora) {
		this.valorHora = valorHora;
	}

}
