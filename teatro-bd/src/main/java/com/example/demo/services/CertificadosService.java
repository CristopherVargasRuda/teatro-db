package com.example.demo.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.models.Empleado;
import com.example.demo.models.Estudiante;
import com.example.demo.models.Obra;
import com.example.demo.models.Personaje;
import com.example.demo.models.PersonajeEstudiante;
import com.example.demo.repositorys.IEstudianteRepository;
import com.example.demo.repositorys.IObraRepository;
import com.example.demo.repositorys.IPersonajeEstudianteRepository;
import com.example.demo.repositorys.IPersonajeRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service("certificadosService")
@Transactional
public class CertificadosService {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	@Qualifier("obraRepository")
	private IObraRepository obraRepository;

	@Autowired
	@Qualifier("estudianteRepository")
	private IEstudianteRepository estudianteRepository;

	@Autowired
	@Qualifier("personajeEstudianteRepository")
	private IPersonajeEstudianteRepository personajeEstudianteRepository;

	@Autowired
	@Qualifier("personajeRepository")
	private IPersonajeRepository personajeRepository;

	public ArrayList<Obra> obtenerObras(Empleado empleado) {
		return (ArrayList<Obra>) obraRepository.obtenerObrasInactivasPorDocente(empleado.getIcodEmpleado());
	}

	public Obra obtenerObraByID(String id) {
		return obraRepository.getById(id);
	}

	public Estudiante getEstudiante(Estudiante estudiante) {
		return estudianteRepository.getPorId(estudiante.getCodEstudiante());
	}

	public ArrayList<Obra> getObrasPorEstudiante(Estudiante estudiante) {
		return obraRepository.obtenerObrasPorEstudiante(estudiante.getCodEstudiante());
	}

	public ArrayList<Estudiante> obtenerEstudiantesOBra(Obra obra) {
		return estudianteRepository.obtenerEstudiantesPorObra(obra.getIdObra());
	}

	public void generarCertificado(HttpServletResponse response, Estudiante estudiante, Obra obra)
			throws IOException, MessagingException {
		ArrayList<PersonajeEstudiante> personajeEstudiantes = personajeEstudianteRepository
				.obtenerPersonajesEstudiante(obra.getIdObra(), estudiante.getCodEstudiante());
		ArrayList<Personaje> personajes = personajeRepository.obtenerPersonajesObra(obra.getIdObra());
		Empleado empleado = DatosLogueoService.getService().getEmpleadoLogueado();

		String fileName = "certificados/certificado " + estudiante.getNombre() + " " + estudiante.getApellido() + " - " 
		+ obra.getTitulo() + ".pdf";	
		
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, new FileOutputStream(fileName));

		documento.open();
		Font fontTitulo1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitulo1.setSize(19);

		Paragraph encabezado1 = new Paragraph("UNIVERSIDAD DISTRITAL FRANCISCO JOSÉ DE CALDAS" + "\n" + "\n" + "\n",
				fontTitulo1);
		encabezado1.setAlignment(Paragraph.ALIGN_CENTER);

		Font fontTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitulo.setSize(14);

		Paragraph encabezado = new Paragraph("CERTIFICADO DE PARTICIPACIÓN EN LA OBRA: " + "\n", fontTitulo);
		encabezado.setAlignment(Paragraph.ALIGN_CENTER);

		Font fontparrafo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontparrafo.setSize(12);

		Paragraph parrafo2 = new Paragraph(obra.getTitulo() + "\n" + "\n", fontTitulo);
		parrafo2.setAlignment(Paragraph.ALIGN_CENTER);

		Paragraph parrafo3 = new Paragraph(
				"DIRECTOR: " + "\n" + empleado.getNombre() + " " + empleado.getApellido() + "\n" + "\n", fontTitulo);
		parrafo3.setAlignment(Paragraph.ALIGN_CENTER);

		Paragraph parrafo4 = new Paragraph(
				"La Universidad Distrital certifica que el estudiante: " + "\n" + "\n" + estudiante.getNombre() + "  "
						+ estudiante.getApellido() + "   " + "Participo en la Obra Satisfactoriamente." + "\n" + "\n",
				fontTitulo);
		parrafo4.setAlignment(Paragraph.ALIGN_CENTER);

		String fei = "";
		String fef = "";
		String per = "";

		for (PersonajeEstudiante personajeEstudiante : personajeEstudiantes) {

			for (Personaje personaje : personajes) {
				if (personaje.getIdPersonaje().equals(personajeEstudiante.getIdPersonaje())) {
					fei = personajeEstudiante.getFechaInicio().toString();
					fef = personajeEstudiante.getFechaFin().toString();
					per = personaje.getNomPersonaje();
				}
			}

		}
		Paragraph parrafo5 = new Paragraph("En el periodo de tiempo comprendido entre: " + "\n" + "\n" + fei + " -- "
				+ fef + "\n" + "\n" + "Interpretando el personaje de: " + "\n" + "\n" + per, fontTitulo);
		parrafo5.setAlignment(Paragraph.ALIGN_CENTER);

		documento.add(encabezado1);
		documento.add(encabezado);
		documento.add(parrafo2);
		documento.add(parrafo3);
		documento.add(parrafo4);
		documento.add(parrafo5);
		documento.close();

		/*
		 * SimpleMailMessage mailMessage = new SimpleMailMessage();
		 * mailMessage.setFrom("teatroud008540@gmail.com");
		 * mailMessage.setTo(estudiante.getMail());
		 * mailMessage.setSubject("Certificado: " + obra.getTitulo());
		 * mailMessage.setText("");
		 */
		// javaMailSender.send(mailMessage);

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
		messageHelper.setFrom("teatroud008540@gmail.com");
		messageHelper.setTo(estudiante.getMail());
		messageHelper.setSubject("Certificado: " + obra.getTitulo());
		messageHelper.setText("");
		String nombreArchivo = "Certificado " + estudiante.getNombre() + " " + estudiante.getApellido() + " - "
				+ obra.getTitulo() + ".pdf";		
		File archivo = new File(fileName);
		messageHelper.addAttachment(nombreArchivo, archivo);
		System.out.println("8");
		mailSender.send(mimeMessage);
		System.out.println("9");
	}

}
