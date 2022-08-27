package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Estudiante;
import com.example.demo.models.Obra;
import com.example.demo.services.AsistenciaService;
import com.example.demo.services.DatosLogueoService;
import com.example.demo.services.EstudiantesSinFirmarService;

@Controller
@RequestMapping
public class AsistenciaController {
	
	@Autowired
	@Qualifier("asistenciaService")
	private AsistenciaService asistenciaService;
	
	@GetMapping("/asistencia")
	public String getAsistencia(Model model) {
		Obra obra = DatosLogueoService.getService().getObraActiva();
		ArrayList<Estudiante> estudiantes;
		if (EstudiantesSinFirmarService.getService().isPermiso()) {
			if (EstudiantesSinFirmarService.getService().getEstudiantesSinFirmar().isEmpty()) {
				estudiantes = asistenciaService.obtenerEstudiantesObra(obra.getIdObra());
				EstudiantesSinFirmarService.getService().setEstudiantesSinFirmar(estudiantes);
			} else {
				estudiantes = EstudiantesSinFirmarService.getService().getEstudiantesSinFirmar();	
			}			
			model.addAttribute("obra", obra);
			model.addAttribute("estudiantes", estudiantes);
			return "asistencia";	
		} else {
			return "redirect:/index";
		}	
	}
	
	@GetMapping("/asistencia/asiste/{id}")
	public String asiste(@PathVariable String id, Model model) {
		asistenciaService.marcarAsistencia(id, DatosLogueoService.getService().getCalendarioActual().getConseCalendario(), DatosLogueoService.getService().getObraActiva().getIdObra());
		EstudiantesSinFirmarService.getService().quitarEstudiante(id);
		Obra obra = DatosLogueoService.getService().getObraActiva();
		ArrayList<Estudiante> estudiantes = EstudiantesSinFirmarService.getService().getEstudiantesSinFirmar();		
		if (estudiantes.isEmpty()) {
			EstudiantesSinFirmarService.getService().setPermiso(false);
			return "redirect:/index";
		}
		model.addAttribute("obra", obra);
		model.addAttribute("estudiantes", estudiantes);
		return "redirect:/asistencia";		
	}
	
	@GetMapping("/asistencia/falta/{id}")
	public String falta(@PathVariable String id, Model model) {
		EstudiantesSinFirmarService.getService().quitarEstudiante(id);
		Obra obra = DatosLogueoService.getService().getObraActiva();
		ArrayList<Estudiante> estudiantes = EstudiantesSinFirmarService.getService().getEstudiantesSinFirmar();		
		if (estudiantes.isEmpty()) {
			EstudiantesSinFirmarService.getService().setPermiso(false);
			return "redirect:/index";
		}
		model.addAttribute("obra", obra);
		model.addAttribute("estudiantes", estudiantes);
		return "redirect:/asistencia";		
	}
	
	@GetMapping("/volverAsistencia")
	public String falta(Model model) {	
		return "redirect:/index";		
	}
	
}
