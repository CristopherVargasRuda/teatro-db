package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Obra;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("obraRepository")
public interface IObraRepository extends JpaRepository<Obra, String> {

	@Query(
			value = "SELECT * FROM obra WHERE estado = 1", 
			nativeQuery = true
	)
	Obra obtenerObraActiva();
	
	@Query(
			value = "SELECT o.* FROM obra o, personalobra p WHERE o.idobra = p.idobra AND p.icodempleado = ?1 AND estado = 0", 
			nativeQuery = true
	)
	ArrayList<Obra> obtenerObrasInactivasPorDocente(@Param("codigo") String codigo);
	
	@Query(
			value = "SELECT o.* "
					+ "FROM estudiante e, personajeestudiante pe, personaje p, obra o "
					+ "WHERE e.codestudiante = pe.codestudiante AND pe.idpersonaje = p.idpersonaje "
					+ "AND pe.idobra = p.idobra AND p.idobra = o.idobra AND o.estado = 0 AND e.codestudiante = ?1", 
			nativeQuery = true
	)
	ArrayList<Obra> obtenerObrasPorEstudiante(@Param("codigo") String codigo);

}
