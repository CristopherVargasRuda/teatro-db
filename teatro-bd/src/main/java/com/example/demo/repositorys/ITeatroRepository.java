package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Teatro;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("teatroRepository")
public interface ITeatroRepository extends JpaRepository<Teatro, String> {

}
