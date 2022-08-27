package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.TipoObra;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("tipoObraRepository")
public interface ITipoObraRepository extends JpaRepository<TipoObra, String> {

}
