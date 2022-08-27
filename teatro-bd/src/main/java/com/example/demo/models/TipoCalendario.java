package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOCALENDARIO")
public class TipoCalendario {

	@Id
	@Column(name = "IDTIPOCALEN", nullable = false)
	private String idTipoCalen;
	@Column(name = " DESCTIPOCALENDARIO", nullable = false)
	private String descTipoCalendario;

	public String getIdTipoCalen() {
		return idTipoCalen;
	}

	public void setIdTipoCalen(String idTipoCalen) {
		this.idTipoCalen = idTipoCalen;
	}

	public String getDescTipoCalendario() {
		return descTipoCalendario;
	}

	public void setDescTipoCalendario(String descTipoCalendario) {
		this.descTipoCalendario = descTipoCalendario;
	}

}
