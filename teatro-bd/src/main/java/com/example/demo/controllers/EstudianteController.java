package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.services.EstudianteService;

@Controller
@CrossOrigin(origins = "*")
@SessionAttributes("estudiante")
public class EstudianteController {

	@Autowired
	@Qualifier("estudianteService")
	private EstudianteService estudianteService;

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	/*
	@GetMapping("/inscripcionEstudiantes")
	public ModelAndView getInscripcionEstudiantes(Model model) {
		return new ModelAndView("inscripcionEstudiantes").addObject("estudiante", new EstudianteAnterior());
		/*Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante", estudiante);
		return "inscripcionEstudiantes";
	}

	@PostMapping("/agregarEstudiante")
	public ModelAndView agregarEstudiante(@Validated @Valid EstudianteAnterior estudiante, BindingResult bindingResult, Model model, SessionStatus status) throws Exception {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("inscripcionEstudiantes").addObject("estudiante", estudiante);
		}
		estudianteService.agregarEstudiante(estudiante);
		estudianteService.crearAudicion(estudiante);
		status.setComplete();
		return new ModelAndView("redirect:index");
	}*/
}
