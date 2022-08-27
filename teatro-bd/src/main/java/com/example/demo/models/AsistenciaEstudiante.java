package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASISTENCIAESTUDIANTE")
public class AsistenciaEstudiante {

	@Id
	@Column(name = "CONSECASIS", nullable = false)
	private long consecAsis;
	@Column(name = "IDOBRA", nullable = false)
	private String idObra;
	@Column(name = "CONSECALENDARIO", nullable = false)
	private long conseCalendario;
	@Column(name = "CODESTUDIANTE", nullable = false)
	private String codEstudiante;

	public long getConsecAsis() {
		return consecAsis;
	}

	public void setConsecAsis(long consecAsis) {
		this.consecAsis = consecAsis;
	}

	public String getIdObra() {
		return idObra;
	}

	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}

	public long getConseCalendario() {
		return conseCalendario;
	}

	public void setConseCalendario(long conseCalendario) {
		this.conseCalendario = conseCalendario;
	}

	public String getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
	}


}
