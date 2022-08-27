package com.example.demo.models;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HORAFECHA")
public class HoraFecha {

	@Id
	@Column(name = "IDHORA", nullable = false)
	private LocalTime idHora;

	public LocalTime getIdHora() {
		return idHora;
	}

	public void setIdHora(LocalTime idHora) {
		this.idHora = idHora;
	}
	
	
	
}
