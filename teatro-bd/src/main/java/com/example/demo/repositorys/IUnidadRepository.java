package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Unidad;

@Repository("unidadRepository")
public interface IUnidadRepository extends JpaRepository<Unidad, String> {

}
