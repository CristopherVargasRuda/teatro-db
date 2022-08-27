package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.EstudianteAnterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository("estudianteRepositorya")
public interface EstudianteRepository extends JpaRepository<EstudianteAnterior, Long> {

	@Query( 
			 value = "INSERT INTO ESTUDIANTE (CODIGO, ID_TIPO_DOCUMENTO, NUMERO_DOCUMENTO_ESTUDIANTE, PRIMER_NOMBRE_ESTUDIANTE, SEGUNDO_NOMBRE_ESTUDIANTE, PRIMER_APELLIDO_ESTUDIANTE, SEGUNDO_APELLIDO_ESTUDIANTE, MAIL_ESTUDIANTE, FECHA_NACIMIENTO_ESTUDIANTE, ID_CARRERA) "
			 		+ "VALUES (:codigo, :idDoc, :numCodEst, :primerNombre, :segundoNombre, :primerApellido, :segundoApellido, :mail, TO_DATE(:fecha, 'yyyy/mm/dd'), :carrera)", 
			 nativeQuery = true 
	) 
	List<EstudianteAnterior> guardarEstudiante(@Param("codigo") String codigo, @Param("idDoc") String idDoc, 
			@Param("numCodEst") String numCodEst, @Param("primerNombre") String primerNombre, 
			@Param("segundoNombre") String segundoNombre, @Param("primerApellido") String primerApellido, 
			@Param("segundoApellido") String segundoApellido, @Param("mail") String mail, @Param("fecha") String fecha, @Param("carrera") String carrera);
	
	@Query( 
			 value = "INSERT INTO ESTUDIANTE (CODIGO, ID_TIPO_DOCUMENTO, NUMERO_DOCUMENTO_ESTUDIANTE, PRIMER_NOMBRE_ESTUDIANTE, SEGUNDO_NOMBRE_ESTUDIANTE, PRIMER_APELLIDO_ESTUDIANTE, SEGUNDO_APELLIDO_ESTUDIANTE, MAIL_ESTUDIANTE, FECHA_NACIMIENTO_ESTUDIANTE, ID_CARRERA) "
			 		+ "VALUES (:sentencia)", 
			 nativeQuery = true 
	) 
	List<EstudianteAnterior> guardarEstudiante2(@Param("sentencia") String sentencia);
	
	@Query(
			value = "INSERT INTO ESTUDIANTE (CODIGO, ID_TIPO_DOCUMENTO, "
					+ "NUMERO_DOCUMENTO_ESTUDIANTE, PRIMER_NOMBRE_ESTUDIANTE, "
					+ "PRIMER_APELLIDO_ESTUDIANTE, SEGUNDO_APELLIDO_ESTUDIANTE, "
					+ "MAIL_ESTUDIANTE, FECHA_NACIMIENTO_ESTUDIANTE, "
					+ "ID_CARRERA) VALUES (%:sentencia%)",
			  nativeQuery = true 
	)
	void guardarEstudianteSinSegundoNombre(@Param("sentencia") String sentencia);
	
	@Query(
			value = "INSERT INTO ESTUDIANTE (CODIGO, ID_TIPO_DOCUMENTO, "
					+ "NUMERO_DOCUMENTO_ESTUDIANTE, PRIMER_NOMBRE_ESTUDIANTE, "
					+ "SEGUNDO_NOMBRE_ESTUDIANTE, PRIMER_APELLIDO_ESTUDIANTE, "
					+ "MAIL_ESTUDIANTE, FECHA_NACIMIENTO_ESTUDIANTE, "
					+ "ID_CARRERA) VALUES (%:sentencia%)",
			  nativeQuery = true 
	)
	void guardarEstudianteSinSegundoApellido(@Param("sentencia") String sentencia);
	
	@Query(
			value = "INSERT INTO ESTUDIANTE (CODIGO, ID_TIPO_DOCUMENTO, "
					+ "NUMERO_DOCUMENTO_ESTUDIANTE, PRIMER_NOMBRE_ESTUDIANTE, "
					+ "PRIMER_APELLIDO_ESTUDIANTE, MAIL_ESTUDIANTE, FECHA_NACIMIENTO_ESTUDIANTE, "
					+ "ID_CARRERA) VALUES (%:sentencia%)",
			  nativeQuery = true 
	)
	void guardarEstudianteSinSegundoNombreNiSegundoApellido(@Param("sentencia") String sentencia);

}
