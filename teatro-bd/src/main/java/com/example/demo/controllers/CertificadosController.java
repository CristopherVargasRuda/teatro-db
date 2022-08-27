package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.models.Estudiante;
import com.example.demo.models.Obra;
import com.example.demo.services.CertificadosService;
import com.example.demo.services.DatosLogueoService;

@Controller
@RequestMapping
public class CertificadosController {

	@Autowired
	@Qualifier("certificadosService")
	private CertificadosService certificadosService;

	@GetMapping("/certificados")
	public String getCertificados(Model model) {
		ArrayList<Obra> obras = certificadosService.obtenerObras(DatosLogueoService.getService().getEmpleadoLogueado());
		model.addAttribute("obras", obras);
		return "certificados";
	}

	@GetMapping("/generarCertificado")
	public String getGenerarCertificado(Model model) {
		Obra obra = DatosLogueoService.getService().getObraElegida();
		System.out.println(obra.getTitulo());
		if (DatosLogueoService.getService().isMostrarObras()) {
			model.addAttribute("mostrarObra", 1);
		} else {
			model.addAttribute("mostrarObra", 0);
		}
		if (DatosLogueoService.getService().getObraElegida() == null) {
			model.addAttribute("obra", new Obra());
		} else {
			model.addAttribute("obra", obra);
		}
		if (DatosLogueoService.getService().getObraSeleccionada() == null) {
			model.addAttribute("obraACertificar", new Obra());
		} else {
			model.addAttribute("obraACertificar", DatosLogueoService.getService().getObraSeleccionada());
		}
		if (DatosLogueoService.getService().getEstudiante() == null) {
			model.addAttribute("estudiante", new Estudiante());
		} else {
			model.addAttribute("estudiante", DatosLogueoService.getService().getEstudiante());
		}
		if (DatosLogueoService.getService().getObrasPorEstudiante() == null) {
			model.addAttribute("obras", new ArrayList<Obra>());
		} else {
			model.addAttribute("obras", DatosLogueoService.getService().getObrasPorEstudiante());
		}
		return "generarCertificado";
	}

	@GetMapping("/generarCertificado/{id}")
	public String generarCertificadoByID(@PathVariable String id, Model model) {
		DatosLogueoService.getService().setMostrarObras(false);
		Obra obra = certificadosService.obtenerObraByID(id);
		DatosLogueoService.getService().setObraElegida(obra);
		model.addAttribute("obra", DatosLogueoService.getService().getObraElegida());
		System.out.println(DatosLogueoService.getService().getObraElegida().getTitulo());
		return "redirect:/generarCertificado";
	}

	@PostMapping("/buscarObras")
	public String buscarObras(@Validated @Valid Estudiante estudiante, BindingResult bindingResult, Model model,
			SessionStatus statu) {

		if (bindingResult.hasErrors()) {
			return "redirect:/generarCertificado";
		}
		Estudiante estudianteIngresado;
		estudianteIngresado = certificadosService.getEstudiante(estudiante);
		System.out.println("");
		if (estudianteIngresado == null) {
			System.out.println("");
			DatosLogueoService.getService().setEstudiante(null);
			DatosLogueoService.getService().setObrasPorEstudiante(null);
			DatosLogueoService.getService().setMostrarObras(false);
			return "redirect:/generarCertificado";
		}
		DatosLogueoService.getService().setEstudiante(estudianteIngresado);
		System.out.println("");
		System.out.println(DatosLogueoService.getService().getEstudiante().getNombre());
		System.out.println("");
		ArrayList<Obra> obras = certificadosService.getObrasPorEstudiante(estudianteIngresado);
		if (!obras.isEmpty()) {
			DatosLogueoService.getService().setObrasPorEstudiante(obras);
			System.out.println(DatosLogueoService.getService().getObrasPorEstudiante().get(0).getTitulo());
			DatosLogueoService.getService().setMostrarObras(true);
		}

		return "redirect:/generarCertificado";
	}

	@PostMapping("/certificarEstudiantePorObra")
	public void certificarEstudiantePorObra(HttpServletResponse response, @Validated @Valid Obra obraACertificar,
			Model model) throws IOException {
		Obra obraSeleccionada = certificadosService.obtenerObraByID(obraACertificar.getIdObra());
		DatosLogueoService.getService().setObraSeleccionada(obraSeleccionada);
		Estudiante estudiante;
		estudiante = DatosLogueoService.getService().getEstudiante();

		response.setContentType("prueba/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Certificado " + estudiante.getNombre() + " "
				+ estudiante.getApellido() + " - " + obraSeleccionada.getTitulo() + ".pdf";
		response.setHeader(headerKey, headerValue);
		try {
			this.certificadosService.generarCertificado(response, estudiante, obraSeleccionada);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/certificarEstudiantes")
	public void certificarEstudiantes(HttpServletResponse response, Model model) throws IOException {
		Obra obra = DatosLogueoService.getService().getObraElegida();
		ArrayList<Estudiante> estudiantes = certificadosService.obtenerEstudiantesOBra(obra);
		for (Estudiante estudiante : estudiantes) {
			response.setContentType("prueba/pdf");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=Certificado " + estudiante.getNombre() + " "
					+ estudiante.getApellido() + " - " + obra.getTitulo() + ".pdf";
			response.setHeader(headerKey, headerValue);
			try {
				this.certificadosService.generarCertificado(response, estudiante, obra);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

}
