package com.example.demo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ESTUDIANTE")

public class EstudianteAnterior {
	@NotNull
	@Id
	@Column(name = "CODIGO", nullable = false)
	private long codigo;
	@NotEmpty
	@Column(name = "ID_TIPO_DOCUMENTO", nullable = false)
	private String idTipoDocumento;
	@NotEmpty
	@NotNull
	@Column(name = "NUMERO_DOCUMENTO_ESTUDIANTE", nullable = false)
	private String numeroDocumento;
	@NotEmpty
	@Column(name = "PRIMER_NOMBRE_ESTUDIANTE", nullable = false)
	private String primerNombre;
	@Column(name = "SEGUNDO_NOMBRE_ESTUDIANTE", nullable = true)
	private String segundoNombre;
	@NotEmpty
	@Column(name = "PRIMER_APELLIDO_ESTUDIANTE", nullable = false)
	private String primerApellido;
	@Column(name = "SEGUNDO_APELLIDO_ESTUDIANTE", nullable = true)
	private String segundoApellido;
	@NotEmpty
	@Email
	@Column(name = "MAIL_ESTUDIANTE", nullable = false)
	private String mail;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHA_NACIMIENTO_ESTUDIANTE", nullable = false)
	private LocalDate fechaNacimiento;
	@NotNull
	@Column(name = "ID_CARRERA", nullable = false)
	private long idCarrera;

	public Long getId() {
		return codigo;
	}

	public void setId(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellido() {
		return primerApellido;
	}

	public void setApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(long idCarrera) {
		this.idCarrera = idCarrera;
	}

}
