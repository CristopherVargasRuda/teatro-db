package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.ListaActividad;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("listaActividadRepository")
public interface IListaActividadRepository extends JpaRepository<ListaActividad, Long> {

}
