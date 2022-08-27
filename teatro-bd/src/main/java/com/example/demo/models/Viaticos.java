package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Viaticos {

	@Id
	private String id;
	private String nomPersonaje;
	private String descTipoCalendario;
	private String fecha;
	private String idHoraInicio;
	private String idHoraFin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomPersonaje() {
		return nomPersonaje;
	}

	public void setNomPersonaje(String nomPersonaje) {
		this.nomPersonaje = nomPersonaje;
	}

	public String getDescTipoCalendario() {
		return descTipoCalendario;
	}

	public void setDescTipoCalendario(String descTipoCalendario) {
		this.descTipoCalendario = descTipoCalendario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdHoraInicio() {
		return idHoraInicio;
	}

	public void setIdHoraInicio(String idHoraInicio) {
		this.idHoraInicio = idHoraInicio;
	}

	public String getIdHoraFin() {
		return idHoraFin;
	}

	public void setIdHoraFin(String idHoraFin) {
		this.idHoraFin = idHoraFin;
	}

}
