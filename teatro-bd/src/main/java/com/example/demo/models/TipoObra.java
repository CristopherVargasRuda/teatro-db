package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOOBRA")
public class TipoObra {

	@Id
	@Column(name = "IDTIPOOBRA", nullable = false)
	private String idTipoObra;

	public String getIdTipoObra() {
		return idTipoObra;
	}

	public void setIdTipoObra(String idTipoObra) {
		this.idTipoObra = idTipoObra;
	}

}
