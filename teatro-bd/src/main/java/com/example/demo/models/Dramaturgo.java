package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRAMATURGO")
public class Dramaturgo {

	@Id
	@Column(name = "IDDRAMATURGO", nullable = false)
	private String idDramaturgo;
	@Column(name = "CODPAIS", nullable = false)
	private long codPais;

	public String getIdDramaturgo() {
		return idDramaturgo;
	}

	public void setIdDramaturgo(String idDramaturgo) {
		this.idDramaturgo = idDramaturgo;
	}

	public long getCodPais() {
		return codPais;
	}

	public void setCodPais(long codPais) {
		this.codPais = codPais;
	}

}
