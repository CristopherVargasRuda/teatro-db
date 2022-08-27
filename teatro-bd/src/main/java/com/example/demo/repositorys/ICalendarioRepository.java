package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Calendario;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("calendarioRepository")
public interface ICalendarioRepository extends JpaRepository<Calendario, Long> {
	
	@Query(
			value = "SELECT * FROM calendario WHERE SYSDATE > idhorainicio AND SYSDATE < idhorafin",
			nativeQuery = true
			)
	Calendario obtenerCalendarioActual();
	
	@Query(
			value = "SELECT * FROM calendario c WHERE idobra = ?1",
			nativeQuery = true
			)
	ArrayList<Calendario> obtenerCalendariosPorObra(@Param("obra") String idObra);
	
	@Query(
			value = "SELECT * FROM calendario WHERE idobra = ?1 AND fecha > SYSDATE ORDER BY fecha DESC",
			nativeQuery = true
			)
	ArrayList<Calendario> obtenerCalendariosPosteriores(@Param("obra") String idObra);
	
}
