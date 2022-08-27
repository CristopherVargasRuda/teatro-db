package com.example.demo.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDICION")
public class AudicionAnterior {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDAUDICION", nullable = false)
	private long idAudicion;
	@Column(name = "CODIGOFK", nullable = false)
	private long codigoFK;
	@Column(name = "FECHA_AUDICION", nullable = false)
	private LocalDate fechaAudicion;
	@Column(name = "HORA_AUDICION", nullable = false)
	private LocalTime horaAudicion;

	public long getIdAudicion() {
		return idAudicion;
	}

	public void setIdAudicion(long idAudicion) {
		this.idAudicion = idAudicion;
	}

	public long getCodigoFK() {
		return codigoFK;
	}

	public void setCodigoFK(long codigoFK) {
		this.codigoFK = codigoFK;
	}

	public LocalDate getFechaAudicion() {
		return fechaAudicion;
	}

	public void setFechaAudicion(LocalDate fechaAudicion) {
		this.fechaAudicion = fechaAudicion;
	}

	public LocalTime getHoraAudicion() {
		return horaAudicion;
	}

	public void setHoraAudicion(LocalTime horaAudicion) {
		this.horaAudicion = horaAudicion;
	}

}
