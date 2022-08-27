package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Estudiante;

public class EstudiantesSinFirmarService {

	static private EstudiantesSinFirmarService estudiantesSinFirmarService;
	private ArrayList<Estudiante> estudiantesSinFirmar;
	private boolean permiso;

	private EstudiantesSinFirmarService() {
		estudiantesSinFirmar = new ArrayList<>();
		permiso = true;
	}

	public void quitarEstudiante(String id) {
		for (int i = 0; i < estudiantesSinFirmar.size(); i++) {
			if (estudiantesSinFirmar.get(i).getCodEstudiante().equals(id)) {
				estudiantesSinFirmar.remove(i);
			}
		}
	}

	public static EstudiantesSinFirmarService getService() {
		if (estudiantesSinFirmarService == null) {
			estudiantesSinFirmarService = new EstudiantesSinFirmarService();
		}
		return estudiantesSinFirmarService;
	}

	public ArrayList<Estudiante> getEstudiantesSinFirmar() {
		return estudiantesSinFirmar;
	}

	public void setEstudiantesSinFirmar(ArrayList<Estudiante> estudiantesSinFirmar) {
		this.estudiantesSinFirmar = estudiantesSinFirmar;
	}

	public boolean isPermiso() {
		return permiso;
	}

	public void setPermiso(boolean permiso) {
		this.permiso = permiso;
	}

}
