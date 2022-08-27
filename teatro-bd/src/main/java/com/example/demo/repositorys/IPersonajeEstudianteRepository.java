package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.PersonajeEstudiante;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("personajeEstudianteRepository")
public interface IPersonajeEstudianteRepository extends JpaRepository<PersonajeEstudiante, Long> {
	
	@Query(
			value = "SELECT * FROM personajeestudiante WHERE idobra = ?1 AND codestudiante = ?2",
			nativeQuery = true
			)
	public ArrayList<PersonajeEstudiante> obtenerPersonajesEstudiante(@Param("obra") String idOBra, @Param("codigo") String codigo);
	
}
