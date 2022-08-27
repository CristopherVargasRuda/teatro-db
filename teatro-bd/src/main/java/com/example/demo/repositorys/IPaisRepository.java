package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Pais;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("paisRepository")
public interface IPaisRepository extends JpaRepository<Pais, Long> {

}
