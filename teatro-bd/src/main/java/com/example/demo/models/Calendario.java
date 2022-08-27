package com.example.demo.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CALENDARIO")
public class Calendario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CONSECALENDARIO", nullable = false)
	private long conseCalendario;
	@Column(name = "IDOBRA", nullable = false)
	private String idObra;
	@Column(name = "IDHORAINICIO", nullable = false)
	private LocalTime idHoraInicio;
	@Column(name = "IDTIPOCALEN", nullable = false)
	private String idTipoCalen;
	@Column(name = "CODTEATRO", nullable = false)
	private String codTeatro;
	@Column(name = "IDHORAFIN", nullable = false)
	private LocalTime idHoraFin;
	@Column(name = "FECHA", nullable = false)
	private LocalDate fecha;

	public long getConseCalendario() {
		return conseCalendario;
	}

	public void setConseCalendario(long conseCalendario) {
		this.conseCalendario = conseCalendario;
	}

	public String getIdObra() {
		return idObra;
	}

	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}

	public LocalTime getIdHoraInicio() {
		return idHoraInicio;
	}

	public void setIdHoraInicio(LocalTime idHoraInicio) {
		this.idHoraInicio = idHoraInicio;
	}

	public String getIdTipoCalen() {
		return idTipoCalen;
	}

	public void setIdTipoCalen(String idTipoCalen) {
		this.idTipoCalen = idTipoCalen;
	}

	public String getCodTeatro() {
		return codTeatro;
	}

	public void setCodTeatro(String codTeatro) {
		this.codTeatro = codTeatro;
	}

	public LocalTime getIdHoraFin() {
		return idHoraFin;
	}

	public void setIdHoraFin(LocalTime idHoraFin) {
		this.idHoraFin = idHoraFin;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
