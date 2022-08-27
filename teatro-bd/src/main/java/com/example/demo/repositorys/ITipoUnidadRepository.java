package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.TipoUnidad;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("tipoUnidadRepository")
public interface ITipoUnidadRepository extends JpaRepository<TipoUnidad, String> {

}
