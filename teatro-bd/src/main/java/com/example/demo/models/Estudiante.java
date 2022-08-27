package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTUDIANTE")
public class Estudiante {

	@Id
	@Column(name = "CODESTUDIANTE", nullable = false)
	private String codEstudiante;
	@Column(name = "CODUNIDAD", nullable = false)
	private String codUnidad;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	@Column(name = "FECHAINSCRIPCION", nullable = false)
	private LocalDate fechaInscripcion;
	@Column(name = "FECHANACIMIENTO", nullable = false)
	private LocalDate fechaNacimiento;
	@Column(name = "MAIL", nullable = false)
	private String mail;

	public String getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
