package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Estudiante;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("estudianteRepository")
public interface IEstudianteRepository extends JpaRepository<Estudiante, String> {

	@Query(
			value = "SELECT * "
					+ "FROM Obra o, Personaje p, PersonajeEstudiante pe, Estudiante e "
					+ "WHERE o.idobra = p.idobra AND p.idobra = pe.idobra AND p.idpersonaje = pe.idpersonaje "
					+ "AND pe.codestudiante = e.codestudiante AND o.idobra = ?1",
			nativeQuery = true
			)
	ArrayList<Estudiante> obtenerEstudiantesPorObra(@Param("obra") String obra);

	@Query(
			value = "SELECT * FROM estudiante WHERE codestudiante = ?1",
			nativeQuery = true
			)
	Estudiante getPorId(@Param("codEstudiante") String codEstudiante);
	
}
