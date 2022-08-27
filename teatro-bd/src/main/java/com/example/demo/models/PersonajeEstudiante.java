package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAJEESTUDIANTE")
public class PersonajeEstudiante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CONSECPERSONAJEESTUDIANTE", nullable = false)
	private long consecPersonajeEstudiante;
	@Column(name = "IDOBRA", nullable = false)
	private String idObra;
	@Column(name = "IDPERSONAJE", nullable = false)
	private String idPersonaje;
	@Column(name = "CODESTUDIANTE", nullable = false)
	private String codEstudiante;
	@Column(name = "FECHAINICIO", nullable = false)
	private LocalDate fechaInicio;
	@Column(name = "FECHAFIN", nullable = false)
	private LocalDate fechaFin;

	public long getConsecPersonajeEstudiante() {
		return consecPersonajeEstudiante;
	}

	public void setConsecPersonajeEstudiante(long consecPersonajeEstudiante) {
		this.consecPersonajeEstudiante = consecPersonajeEstudiante;
	}

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

	public String getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
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
