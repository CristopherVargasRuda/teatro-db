package com.example.demo.repositorys;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AsistenciaEstudiante;


@Repository("asistenciaEstudianteRepository")
public interface IAsistenciaEstudianteRepository extends JpaRepository<AsistenciaEstudiante, Long> {

	@Query(
			value = "SELECT * FROM asistenciaestudiante ORDER BY consecasis DESC",
			nativeQuery = true
			)
	public ArrayList<AsistenciaEstudiante> obtenerAsistencias();
	
	@Query(
			value = "SELECT * FROM asistenciaestudiante WHERE idobra = ?1",
			nativeQuery = true
			)
	public ArrayList<AsistenciaEstudiante> obtenerAsistenciasPorObra(@Param("obra") String idOBra);
	
}
