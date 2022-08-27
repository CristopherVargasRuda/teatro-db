package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("rolRepository")
public interface IRolRepository extends JpaRepository<Rol, Long> {

}
