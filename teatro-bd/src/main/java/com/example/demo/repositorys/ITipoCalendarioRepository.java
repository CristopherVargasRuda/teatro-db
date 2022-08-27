package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.TipoCalendario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("tipoCalendarioRepository")
public interface ITipoCalendarioRepository extends JpaRepository<TipoCalendario, String> {

}
