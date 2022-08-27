package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Periodo;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("periodoRepository")
public interface IPeriodoRepository extends JpaRepository<Periodo, Long> {

}
