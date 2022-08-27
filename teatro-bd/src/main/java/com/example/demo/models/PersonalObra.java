package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONALOBRA")
public class PersonalObra {

	@Id
	@Column(name = "CODUNIDAD", nullable = false)
	private String codUnidad;
	@Column(name = "ICODEMPLEADO", nullable = false)
	private String icodEmpleado;
	@Column(name = "IDPERSONALOBRA", nullable = false)
	private long idPersonalObra;
	@Column(name = "ROL", nullable = true)
	private long rol;
	@Column(name = "IDOBRA", nullable = true)
	private String idObra;
	@Column(name = "FECHAINICIO", nullable = false)
	private LocalDate fechaInicio;
	@Column(name = "FECHAFIN", nullable = true)
	private LocalDate fechaFin;

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getIcodEmpleado() {
		return icodEmpleado;
	}

	public void setIcodEmpleado(String icodEmpleado) {
		this.icodEmpleado = icodEmpleado;
	}

	public long getIdPersonalObra() {
		return idPersonalObra;
	}

	public void setIdPersonalObra(long idPersonalObra) {
		this.idPersonalObra = idPersonalObra;
	}

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}

	public String getIdObra() {
		return idObra;
	}

	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

}
