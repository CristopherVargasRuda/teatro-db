package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.models.EstudianteAnterior;
import com.example.demo.repositorys.AudicionRepository;
import com.example.demo.repositorys.EstudianteRepository;

import com.example.demo.models.AudicionAnterior;

@Service("estudianteService")
@Transactional
public class EstudianteService {

	@Autowired
	@Qualifier("estudianteRepositorya")
	private EstudianteRepository estudianteRepository;

	@Autowired
	@Qualifier("audicionRepository")
	private AudicionRepository audicionRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	public void agregarEstudiante(EstudianteAnterior estudiante) {
		estudianteRepository.save(estudiante);
	}

	public void crearAudicion(EstudianteAnterior estudiante) throws Exception {
		List<AudicionAnterior> audiciones;
		AudicionAnterior audicion = new AudicionAnterior();
		audicion.setCodigoFK(estudiante.getCodigo());
		try {
			audiciones = (List<AudicionAnterior>) audicionRepository.obtenerUltimaAudicion();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			throw new Exception(e.getMessage());
		}
		if (audiciones.isEmpty()) {
			audicion.setFechaAudicion(LocalDate.of(2022, 03, 7));
			audicion.setHoraAudicion(LocalTime.of(8, 00));
			audicion.setIdAudicion(1);
		} else {
			AudicionAnterior lastAudicion = audiciones.get(0);
			if (lastAudicion.getHoraAudicion() == LocalTime.parse("17:00")) {
				if (lastAudicion.getFechaAudicion().getDayOfWeek().getValue() == 5) {
					audicion.setFechaAudicion(lastAudicion.getFechaAudicion().plusDays(3));
					audicion.setHoraAudicion(lastAudicion.getHoraAudicion().plusHours(65));
				} else {
					audicion.setFechaAudicion(lastAudicion.getFechaAudicion().plusDays(1));
					audicion.setHoraAudicion(lastAudicion.getHoraAudicion().plusHours(17));
				}			
			} else {
				audicion.setHoraAudicion(lastAudicion.getHoraAudicion().plusHours(1));
				audicion.setFechaAudicion(lastAudicion.getFechaAudicion());
			}
			audicion.setIdAudicion(lastAudicion.getIdAudicion() + 1);
		}

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom("teatroud008540@gmail.com");
		mailMessage.setTo(estudiante.getMail());
		mailMessage
				.setSubject("Citación Audición " + estudiante.getPrimerNombre() + " " + estudiante.getPrimerApellido());
		mailMessage.setText("Su solicitud fue aceptada, lo esperamos para su audición el día "
				+ audicion.getFechaAudicion() + " a la hora " + audicion.getHoraAudicion() + "\n\n"
				+ "Si sus datos no son \n" + "Nombre: " + estudiante.getPrimerNombre() + estudiante.getApellido()
				+ " Estudiante de la Universidad Distrital (la Universidad de la capital embajadora), "
				+ "haga caso omiso \n\n Cordialmente TeatroUD:"
				+ "\nCristian Camilo Niño Rincón \t - \t Gerente de tintos y empanadas"
				+ "\nCristopher Vargas Ruda       \t - \t Gallina AZUL"
				+ "\n\n Merecemos el 50 :3");

		javaMailSender.send(mailMessage);

		audicionRepository.save(audicion);
	}

}
