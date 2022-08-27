package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LISTAGASTO")
public class ListaGasto {

	@Id
	@Column(name = "IDPERIODO", nullable = false)
	private long idPeriodo;
	@Column(name = "CODGASTO", nullable = false)
	private String codGasto;

	public long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getCodGasto() {
		return codGasto;
	}

	public void setCodGasto(String codGasto) {
		this.codGasto = codGasto;
	}

}
