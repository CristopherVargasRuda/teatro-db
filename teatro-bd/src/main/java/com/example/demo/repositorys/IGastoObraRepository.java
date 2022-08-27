package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.GastoObra;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("gastoObraRepository")
public interface IGastoObraRepository extends JpaRepository<GastoObra, Long> {

}
