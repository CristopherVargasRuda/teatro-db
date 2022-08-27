package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GASTOOBRA")
public class GastoObra {

	@Id
	@Column(name = "CONSEC", nullable = false)
	private long consec;
	@Column(name = "IDPERIODO", nullable = false)
	private long idPeriodo;
	@Column(name = "CODGASTO", nullable = false)
	private String codGasto;	
	@Column(name = "IDOBRA", nullable = false)
	private String idObra;
	@Column(name = "FECHAGASTO", nullable = false)
	private LocalDate fachaGasto;

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

	public long getConsec() {
		return consec;
	}

	public void setConsec(long consec) {
		this.consec = consec;
	}

	public String getIdObra() {
		return idObra;
	}

	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}

	public LocalDate getFachaGasto() {
		return fachaGasto;
	}

	public void setFachaGasto(LocalDate fachaGasto) {
		this.fachaGasto = fachaGasto;
	}

}
