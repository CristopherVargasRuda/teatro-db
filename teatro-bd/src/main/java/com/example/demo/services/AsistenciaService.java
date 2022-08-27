package com.example.demo.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.AsistenciaEstudiante;
import com.example.demo.models.Estudiante;
import com.example.demo.repositorys.IAsistenciaEstudianteRepository;
import com.example.demo.repositorys.IEstudianteRepository;

@Service("asistenciaService")
@Transactional
public class AsistenciaService {	
			
	@Autowired
	@Qualifier("estudianteRepository")
	private IEstudianteRepository estudianteRepository;
	
	@Autowired
	@Qualifier("asistenciaEstudianteRepository")
	private IAsistenciaEstudianteRepository asistenciaEstudianteRepository;
	
	public ArrayList<Estudiante> obtenerEstudiantesObra(String idObra) {
		ArrayList<Estudiante> estudiantes = estudianteRepository.obtenerEstudiantesPorObra(idObra);
		return estudiantes;
	}
	
	
	public void marcarAsistencia(String idEstudiante, long calendario, String obra) {
		AsistenciaEstudiante asistenciaEstudiante = new AsistenciaEstudiante();
		asistenciaEstudiante.setCodEstudiante(idEstudiante);
		asistenciaEstudiante.setConseCalendario(calendario);
		asistenciaEstudiante.setIdObra(obra);
		
		ArrayList <AsistenciaEstudiante> asistencias = asistenciaEstudianteRepository.obtenerAsistencias();
		
		if (asistencias.isEmpty()) {
			asistenciaEstudiante.setConsecAsis(1);
		} else {
			asistenciaEstudiante.setConsecAsis(asistencias.get(0).getConsecAsis() + 1);
		}
		
		
		asistenciaEstudianteRepository.save(asistenciaEstudiante);
	}
		
}
