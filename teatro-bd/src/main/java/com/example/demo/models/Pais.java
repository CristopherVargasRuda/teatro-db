package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class Pais {

	@Id
	@Column(name = "CODPAIS", nullable = false)
	private long codPais;

	public long getCodPais() {
		return codPais;
	}

	public void setCodPais(long codPais) {
		this.codPais = codPais;
	}

}
