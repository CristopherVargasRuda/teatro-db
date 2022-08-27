package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Login {

	@Id
	@NotNull
	private String icodEmpleado;
	private long rol;

	public String getIcodEmpleado() {
		return icodEmpleado;
	}

	public void setIcodEmpleado(String icodEmpleado) {
		this.icodEmpleado = icodEmpleado;
	}

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}

}
