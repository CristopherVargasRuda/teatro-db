package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AudicionAnterior;

@Repository("audicionRepository")
public interface AudicionRepository extends JpaRepository<AudicionAnterior, Long> {

	/*
	 * @Query(
	 * 
	 * value = "SELECT * " +
	 * "FROM (SELECT * FROM AUDICION ORDER BY fecha_audicion DESC, hora_audicion DESC) "
	 * + "WHERE rownum = 1",
	 * 
	 * value =
	 * "SELECT * FROM AUDICION ORDER BY FECHA_AUDICION DESC, HORA_AUDICION DESC",
	 * nativeQuery = true) List<Audicion> obtenerUltimaAudicion();
	 */

	@Query( 
			 value = "SELECT * FROM AUDICION ORDER BY FECHA_AUDICION DESC, HORA_AUDICION DESC", 
			 nativeQuery = true 
	)
	List<AudicionAnterior> obtenerUltimaAudicion();

}
