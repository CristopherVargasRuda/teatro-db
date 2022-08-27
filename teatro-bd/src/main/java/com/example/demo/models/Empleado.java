package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

	@Id
	@NotNull
	@Column(name = "ICODEMPLEADO", nullable = false)
	private String icodEmpleado;
	@Column(name = "CODUNIDAD", nullable = false)
	private String codUnidad;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	@Column(name = "CEDULA", nullable = true)
	private long cedula;
	@Column(name = "CELULAR", nullable = false)
	private long celular;
	@Column(name = "CORREO", nullable = false)
	private String correo;

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

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
