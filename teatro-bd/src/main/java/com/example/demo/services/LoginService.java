package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Calendario;
import com.example.demo.models.Empleado;
import com.example.demo.models.Obra;
import com.example.demo.models.PersonalObra;
import com.example.demo.repositorys.ICalendarioRepository;
import com.example.demo.repositorys.IEmpleadoRepository;
import com.example.demo.repositorys.IObraRepository;
import com.example.demo.repositorys.IPersonalObraRepository;

@Service("loginService")
@Transactional
public class LoginService {
	
	@Autowired
	@Qualifier("obraRepository")
	private IObraRepository obraRepository;
	
	@Autowired
	@Qualifier("calendarioRepository")
	private ICalendarioRepository calendarioRepository;
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("personalObraRepository")
	private IPersonalObraRepository personalObraRepository;
	
	public Empleado loguearEmpleado(String empleado) {
		return empleadoRepository.obtenerEmpleado(empleado);
	}
	
	public Obra obtenerObraActiva() {
		return obraRepository.obtenerObraActiva();
	}

	public int obtenerTipoSesion(Obra obra, Empleado empleado) {
		if (personalObraRepository.consultarSiEsDocentePorObra(empleado.getIcodEmpleado(), obra.getIdObra()) == null) {
			return 3;
		} else if (calendarioRepository.obtenerCalendarioActual() != null) {
			if (!EstudiantesSinFirmarService.getService().isPermiso()) {
				return 3;
			}
			return 1;
		} else if (calendarioRepository.obtenerCalendariosPosteriores(obra.getIdObra()).isEmpty()) {
			return 2;
		}
		return 3;
	}

	public String obtenerHorarioActual() {
		LocalDate fecha = LocalDate.now();
		return fecha.toString();
	}

	public void cargarDatos(Obra obra, Empleado empleadoLogueado, Calendario calendario) {
		DatosLogueoService.getService().setObraActiva(obra);
		DatosLogueoService.getService().setEmpleadoLogueado(empleadoLogueado);
		DatosLogueoService.getService().setCalendarioActual(calendario);
	}

	public Calendario cargarCalendario() {		
		return calendarioRepository.obtenerCalendarioActual();
	}

	public boolean comprobarSiEsDocente(Empleado empleadoLogueado) {
		ArrayList<PersonalObra> personalObras = personalObraRepository.consultarSiEsDocente(empleadoLogueado.getIcodEmpleado());
		if (!personalObras.isEmpty()) {
			return false;
		}
		return true;
	}

}
