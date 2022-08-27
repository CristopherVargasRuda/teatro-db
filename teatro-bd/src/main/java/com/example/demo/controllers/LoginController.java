package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.models.Calendario;
import com.example.demo.models.Empleado;
import com.example.demo.models.Login;
import com.example.demo.models.Obra;
import com.example.demo.services.LoginService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	@GetMapping("/login")
	public String getLogin(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("/sesionDocente")
	public String Loguearse(@Validated @Valid Login login, BindingResult bindingResult, Model model, SessionStatus statu) {
		if (bindingResult.hasErrors() || login.getRol() != 1) {
			model.addAttribute("login", login);
			return "login";
		}

		Empleado empleadoLogueado;
		Obra obra;
		Calendario calendario = new Calendario();
		int tipoCalendario;
		String horarioActual;
		
		empleadoLogueado = loginService.loguearEmpleado(login.getIcodEmpleado());
		
		if (empleadoLogueado == null) {
			model.addAttribute("login", login);
			return "login";
		}
		
		if (loginService.comprobarSiEsDocente(empleadoLogueado)) {
			model.addAttribute("login", login);
			return "login";
		}
		
		obra = loginService.obtenerObraActiva();
		horarioActual = loginService.obtenerHorarioActual();

		if (obra == null) {
			obra = new Obra();
			obra.setTitulo("Sin obras activas");
			tipoCalendario = 3;
		} else {
			tipoCalendario = loginService.obtenerTipoSesion(obra, empleadoLogueado);
			if (tipoCalendario == 1) {
				calendario = loginService.cargarCalendario();
			}	
			if (tipoCalendario == 3) {
				obra = new Obra();
				obra.setTitulo("Sin obras activas");
			}
		}	
		
		loginService.cargarDatos(obra, empleadoLogueado, calendario);
				
		model.addAttribute("empleado", empleadoLogueado);
		model.addAttribute("obra", obra);
		model.addAttribute("calendario", tipoCalendario);
		model.addAttribute("horarioActual", horarioActual);
		
		return "sesionDocente";
	}

}
