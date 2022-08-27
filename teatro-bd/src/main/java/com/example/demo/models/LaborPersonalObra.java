package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LABORPERSONALOBRA")
public class LaborPersonalObra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CONSCELABOR", nullable = false)
	private long consceLabor;
	@Column(name = "IDPERIODO", nullable = false)
	private long idPeriodo;
	@Column(name = "CODACTIVIDAD", nullable = false)
	private String codActividad;
	@Column(name = "CODUNIDAD", nullable = true)
	private String codUnidad;
	@Column(name = "ICODEMPLEADO", nullable = true)
	private String iCodEmpleado;
	@Column(name = "IDPERSONALOBRA", nullable = true)
	private long idPersonalObra;
	@Column(name = "IDOBRA", nullable = true)
	private String idObra;
	@Column(name = "CONSECALENDARIO", nullable = true)
	private long conseCalendario;

	public long getConsceLabor() {
		return consceLabor;
	}

	public void setConsceLabor(long consceLabor) {
		this.consceLabor = consceLabor;
	}

	public long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getCodActividad() {
		return codActividad;
	}

	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getiCodEmpleado() {
		return iCodEmpleado;
	}

	public void setiCodEmpleado(String iCodEmpleado) {
		this.iCodEmpleado = iCodEmpleado;
	}

	public long getIdPersonalObra() {
		return idPersonalObra;
	}

	public void setIdPersonalObra(long idPersonalObra) {
		this.idPersonalObra = idPersonalObra;
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

}
