package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, String> {
	
	@Query(
			value = "SELECT * FROM Empleado e WHERE e.icodempleado = ?1",
			nativeQuery = true
			)
	Empleado obtenerEmpleado(@Param("codigo") String codigo);
	
}
