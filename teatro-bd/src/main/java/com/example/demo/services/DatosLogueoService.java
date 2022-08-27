package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Calendario;
import com.example.demo.models.Empleado;
import com.example.demo.models.Estudiante;
import com.example.demo.models.Obra;

public class DatosLogueoService {

	static private DatosLogueoService datosLogueoService;
	private Obra obraActiva;
	private Empleado empleadoLogueado;
	private Calendario calendarioActual;
	private boolean mostrarObras;
	private int liquidar;

	private Obra obraElegida;
	private Estudiante estudiante;
	private Obra obraSeleccionada;
	private ArrayList<Obra> obrasPorEstudiante;

	private DatosLogueoService() {
		liquidar = 1;
		mostrarObras = false;
		obraElegida = null;
		estudiante = null;
		obraSeleccionada = null;
		obrasPorEstudiante = null;
	}

	public static DatosLogueoService getService() {
		if (datosLogueoService == null) {
			datosLogueoService = new DatosLogueoService();
		}
		return datosLogueoService;
	}

	public Obra getObraActiva() {
		return obraActiva;
	}

	public void setObraActiva(Obra obraActiva) {
		this.obraActiva = obraActiva;
	}

	public static DatosLogueoService getDocenteLogueadoService() {
		return datosLogueoService;
	}

	public static void setDocenteLogueadoService(DatosLogueoService docenteLogueadoService) {
		DatosLogueoService.datosLogueoService = docenteLogueadoService;
	}

	public Empleado getEmpleadoLogueado() {
		return empleadoLogueado;
	}

	public void setEmpleadoLogueado(Empleado empleadoLogueado) {
		this.empleadoLogueado = empleadoLogueado;
	}

	public Calendario getCalendarioActual() {
		return calendarioActual;
	}

	public void setCalendarioActual(Calendario calendarioActual) {
		this.calendarioActual = calendarioActual;
	}

	public Obra getObraElegida() {
		return obraElegida;
	}

	public void setObraElegida(Obra obraElegida) {
		this.obraElegida = obraElegida;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Obra getObraSeleccionada() {
		return obraSeleccionada;
	}

	public void setObraSeleccionada(Obra obraSeleccionada) {
		this.obraSeleccionada = obraSeleccionada;
	}

	public ArrayList<Obra> getObrasPorEstudiante() {
		return obrasPorEstudiante;
	}

	public void setObrasPorEstudiante(ArrayList<Obra> obrasPorEstudiante) {
		this.obrasPorEstudiante = obrasPorEstudiante;
	}

	public boolean isMostrarObras() {
		return mostrarObras;
	}

	public void setMostrarObras(boolean mostrarObras) {
		this.mostrarObras = mostrarObras;
	}

	public int getLiquidar() {
		return liquidar;
	}

	public void setLiquidar(int liquidar) {
		this.liquidar = liquidar;
	}

}
