package com.example.demo.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.AsistenciaEstudiante;
import com.example.demo.models.Calendario;
import com.example.demo.models.Empleado;
import com.example.demo.models.Estudiante;
import com.example.demo.models.Obra;
import com.example.demo.models.TipoCalendario;
import com.example.demo.models.Viaticos;
import com.example.demo.repositorys.IAsistenciaEstudianteRepository;
import com.example.demo.repositorys.ICalendarioRepository;
import com.example.demo.repositorys.IEstudianteRepository;
import com.example.demo.repositorys.IObraRepository;
import com.example.demo.repositorys.ITipoCalendarioRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service("viaticosService")
@Transactional
public class ViaticosService {

	private ArrayList<Estudiante> estudiantesPDF;
	private ArrayList<Viaticos> viaticosPDF;
	private ArrayList<Calendario> calendarios;
	private Empleado empleado;
	private Obra obra;

	@Autowired
	@Qualifier("estudianteRepository")
	private IEstudianteRepository estudianteRepository;

	@Autowired
	@Qualifier("obraRepository")
	private IObraRepository obraRepository;

	@Autowired
	@Qualifier("asistenciaEstudianteRepository")
	private IAsistenciaEstudianteRepository asistenciaEstudianteRepository;

	@Autowired
	@Qualifier("calendarioRepository")
	private ICalendarioRepository calendarioRepository;

	@Autowired
	@Qualifier("tipoCalendarioRepository")
	private ITipoCalendarioRepository tipoCalendarioRepository;

	public ArrayList<Estudiante> cargarEstudiantes(Obra obra) {
		ArrayList<Estudiante> estudiantes = estudianteRepository.obtenerEstudiantesPorObra(obra.getIdObra());
		return estudiantes;
	}

	public ArrayList<Viaticos> cargarViaticos(ArrayList<Estudiante> estudiantes, Obra obra) {
		ArrayList<Viaticos> viaticos = new ArrayList<>();

		ArrayList<Calendario> calendarios = calendarioRepository.obtenerCalendariosPorObra(obra.getIdObra());
		ArrayList<TipoCalendario> tipocalendarios = (ArrayList<TipoCalendario>) tipoCalendarioRepository.findAll();
		ArrayList<AsistenciaEstudiante> asistenciaEstudiantes = asistenciaEstudianteRepository
				.obtenerAsistenciasPorObra(obra.getIdObra());

		for (Estudiante estudiante : estudiantes) {
			for (AsistenciaEstudiante asistenciaEstudiante : asistenciaEstudiantes) {
				if (estudiante.getCodEstudiante().equals(asistenciaEstudiante.getCodEstudiante())) {
					for (Calendario calendario : calendarios) {
						if (asistenciaEstudiante.getConseCalendario() == calendario.getConseCalendario()) {
							Viaticos viatico = new Viaticos();
							viatico.setId(estudiante.getCodEstudiante());
							viatico.setFecha(calendario.getFecha().toString());
							viatico.setIdHoraInicio(calendario.getIdHoraInicio().toString());
							viatico.setIdHoraFin(calendario.getIdHoraFin().toString());
							for (TipoCalendario tipoCalendario : tipocalendarios) {
								if (calendario.getIdTipoCalen().equals(tipoCalendario.getIdTipoCalen())) {
									viatico.setDescTipoCalendario(tipoCalendario.getDescTipoCalendario());
								}
							}
							viaticos.add(viatico);
						}
					}
				}
			}
		}

		return viaticos;
	}

	public void crearPDF(HttpServletResponse response) throws IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fontTitulo1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitulo1.setSize(19);

		Font fontTitulo2 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitulo2.setSize(17);

		Paragraph encabezado1 = new Paragraph("UNIVERSIDAD DISTRITAL FRANCISCO JOSÉ DE CALDAS" + "\n" + "\n",
				fontTitulo1);
		encabezado1.setAlignment(Paragraph.ALIGN_CENTER);

		Paragraph encabezado2 = new Paragraph(
				"Decanatura Facultad de Artes \n Liquidacion viaticos estudiantes de la Obra:" + "\n" + "\n",
				fontTitulo2);
		encabezado2.setAlignment(Paragraph.ALIGN_LEFT);

		Font fontparrafo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontparrafo.setSize(12);

		Font recursos = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		recursos.setSize(14);

		String textoObraa;
		textoObraa = obra.getTitulo() + "\n" + "\n";

		Paragraph parrafo1 = new Paragraph(textoObraa, fontTitulo2);
		parrafo1.setAlignment(Paragraph.ALIGN_CENTER);

		Paragraph parrafo2 = new Paragraph("Desarrollado en el periodo comprendido entre: " + "\n" + "\n", fontTitulo2);
		parrafo2.setAlignment(Paragraph.ALIGN_LEFT);

		String textoObra;

		textoObra = "Fecha Inicio: " + calendarios.get(0).getFecha().toString() + "\n";
		textoObra += "Fecha Fin:     " + calendarios.get(calendarios.size() - 1).getFecha().toString() + "\n" + "\n"
				+ "\n";

		Paragraph parrafo3 = new Paragraph(textoObra, recursos);
		parrafo3.setAlignment(Paragraph.ALIGN_LEFT);

		Paragraph parrafo4 = new Paragraph("Con la Asistencia y Participación de los Estudiantes: " + "\n" + "\n",
				fontTitulo2);
		parrafo4.setAlignment(Paragraph.ALIGN_LEFT);

		String est = "";

		for (Estudiante estudiante : estudiantesPDF) {
			est += estudiante.getNombre() + " " + estudiante.getApellido() + "  -  " + estudiante.getCodEstudiante()
					+ ":\n";
			for (Viaticos viatico : viaticosPDF) {
				if (estudiante.getCodEstudiante() == viatico.getId()) {
					est += "\t\t\t    Sección:        " + viatico.getDescTipoCalendario() + "\n";
					est += "\t\t\t    Fecha:           " + viatico.getFecha() + "\n";
					est += "\t\t\t    Hora Inicio:  " + viatico.getIdHoraInicio() + "\n";
					est += "\t\t\t    Hora Fin:      " + viatico.getIdHoraFin() + "\n\n";
				}
			}
			est += "___________________________\n\n";
		}

		Paragraph parrafo5 = new Paragraph(est, fontparrafo);
		parrafo5.setAlignment(Paragraph.ALIGN_LEFT);

		Paragraph parrafo6 = new Paragraph(("Director de Obra: " + empleado.getNombre() + " " + empleado.getApellido()
				+ "\n " + "Cedula: " + empleado.getCedula() + "\n " + "Fcultad: " + empleado.getCodUnidad()),
				fontTitulo2);
		parrafo6.setAlignment(Paragraph.ALIGN_LEFT);

		documento.add(encabezado1);
		documento.add(encabezado2);
		documento.add(parrafo1);
		documento.add(parrafo2);
		documento.add(parrafo3);
		documento.add(parrafo4);
		documento.add(parrafo5);
		documento.add(parrafo6);

		documento.close();
	}

	public void bloquearObra(Obra obra) {
		obra.setEstado(false);
		obraRepository.save(obra);
	}

	public void cargarDatosPDF(ArrayList<Estudiante> estudiantes, ArrayList<Viaticos> viaticos, Empleado empleado,
			Obra obra) {
		this.estudiantesPDF = estudiantes;
		this.viaticosPDF = viaticos;
		this.empleado = empleado;
		this.obra = obra;
		this.calendarios = calendarioRepository.obtenerCalendariosPorObra(obra.getIdObra());
		for (Estudiante estudiante : estudiantesPDF) {
			System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
			for (Viaticos viatico : viaticosPDF) {
				if (estudiante.getCodEstudiante() == viatico.getId()) {
					System.out.println(viatico.getFecha());
				}
			}
		}
	}
}
