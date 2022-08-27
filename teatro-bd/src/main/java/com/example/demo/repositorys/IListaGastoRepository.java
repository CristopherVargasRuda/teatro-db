package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.ListaGasto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("listaGastoRepository")
public interface IListaGastoRepository extends JpaRepository<ListaGasto, Long> {

}
