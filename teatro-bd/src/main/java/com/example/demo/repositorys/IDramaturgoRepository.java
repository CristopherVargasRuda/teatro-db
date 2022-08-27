package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Dramaturgo;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("dramaturgoRepository")
public interface IDramaturgoRepository extends JpaRepository<Dramaturgo, String> {

}
