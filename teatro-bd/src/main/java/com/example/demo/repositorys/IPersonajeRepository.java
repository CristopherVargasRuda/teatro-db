package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Personaje;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("personajeRepository")
public interface IPersonajeRepository extends JpaRepository<Personaje, String> {

	@Query(
			value = "SELECT * FROM personaje WHERE idobra = ?1",
			nativeQuery = true
			)
	public ArrayList<Personaje> obtenerPersonajesObra(@Param("obra") String idOBra);
}
