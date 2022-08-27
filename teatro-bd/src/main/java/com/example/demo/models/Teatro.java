package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEATRO")
public class Teatro {

	@Id
	@Column(name = "CODTEATRO", nullable = false)
	private String codTeatro;
	@Column(name = "NOMTEATRO", nullable = false)
	private String nomTeatro;
	@Column(name = "DIRECCIONTEA", nullable = false)
	private String direccionTea;

	public String getCodTeatro() {
		return codTeatro;
	}

	public void setCodTeatro(String codTeatro) {
		this.codTeatro = codTeatro;
	}

	public String getNomTeatro() {
		return nomTeatro;
	}

	public void setNomTeatro(String nomTeatro) {
		this.nomTeatro = nomTeatro;
	}

	public String getDireccionTea() {
		return direccionTea;
	}

	public void setDireccionTea(String direccionTea) {
		this.direccionTea = direccionTea;
	}

}
