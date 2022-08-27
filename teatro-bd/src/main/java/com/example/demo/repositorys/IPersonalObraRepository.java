package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.PersonalObra;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("personalObraRepository")
public interface IPersonalObraRepository extends JpaRepository<PersonalObra, String> {

	@Query(
			value = "SELECT * FROM personalobra WHERE rol = 1 AND icodempleado = ?1",
			nativeQuery = true
			)
	ArrayList<PersonalObra> consultarSiEsDocente(@Param("iCodEmpleado") String iCodEmpleado);
	
	@Query(
			value = "SELECT * FROM personalobra WHERE rol = 1 AND icodempleado = ?1 AND idobra = ?2",
			nativeQuery = true
			)
	PersonalObra consultarSiEsDocentePorObra(@Param("iCodEmpleado") String iCodEmpleado, @Param("idObra") String idObra);
	
}
