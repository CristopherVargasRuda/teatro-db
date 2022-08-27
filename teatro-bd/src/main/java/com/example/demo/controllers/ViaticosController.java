package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Empleado;
import com.example.demo.models.Estudiante;
import com.example.demo.models.Obra;
import com.example.demo.models.Viaticos;
import com.example.demo.services.DatosLogueoService;
import com.example.demo.services.ViaticosService;

@Controller
@RequestMapping
public class ViaticosController {

	@Autowired
	@Qualifier("viaticosService")
	private ViaticosService viaticosService;

	@GetMapping("/viaticos")
	public String getViaticos(Model model) {
		Obra obra = DatosLogueoService.getService().getObraActiva();
		ArrayList<Estudiante> estudiantes = viaticosService.cargarEstudiantes(obra);
		ArrayList<Viaticos> viaticos = viaticosService.cargarViaticos(estudiantes, obra);
		
		model.addAttribute("obra", obra);
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("viaticos", viaticos);
		model.addAttribute("liquidar", DatosLogueoService.getService().getLiquidar());
		
		return "/viaticos";
	}

	@GetMapping("/generarViaticos")
	public void generarPDF(HttpServletResponse response, Model model) throws IOException {
		Obra obra = DatosLogueoService.getService().getObraActiva();
		ArrayList<Estudiante> estudiantes = viaticosService.cargarEstudiantes(obra);
		ArrayList<Viaticos> viaticos = viaticosService.cargarViaticos(estudiantes, obra);
		Empleado empleado = DatosLogueoService.getService().getEmpleadoLogueado();
		viaticosService.cargarDatosPDF(estudiantes, viaticos, empleado, obra);
		
		response.setContentType("prueba/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Viaticos " + DatosLogueoService.getService().getObraActiva().getTitulo() + ".pdf";
		response.setHeader(headerKey, headerValue);
		this.viaticosService.crearPDF(response);	
		
		viaticosService.bloquearObra(obra);
	}

}
