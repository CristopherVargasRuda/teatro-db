package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OBRA")
public class Obra {

	@Id
	@Column(name = "IDOBRA", nullable = false)
	private String idObra;
	@Column(name = "IDTIPOOBRA", nullable = false)
	private String idTipoObra;
	@Column(name = "CODPAIS", nullable = false)
	private long codPais;
	@Column(name = "IDDRAMATURGO", nullable = false)
	private String idDramaturgo;
	@Column(name = "FECHAOBRA", nullable = false)
	private LocalDate fechaObra;
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;

	public String getIdObra() {
		return idObra;
	}

	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}

	public String getIdTipoObra() {
		return idTipoObra;
	}

	public void setIdTipoObra(String idTipoObra) {
		this.idTipoObra = idTipoObra;
	}

	public long getCodPais() {
		return codPais;
	}

	public void setCodPais(long codPais) {
		this.codPais = codPais;
	}

	public LocalDate getFechaObra() {
		return fechaObra;
	}

	public void setFechaObra(LocalDate fechaObra) {
		this.fechaObra = fechaObra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getIdDramaturgo() {
		return idDramaturgo;
	}

	public void setIdDramaturgo(String idDramaturgo) {
		this.idDramaturgo = idDramaturgo;
	}

	
}
