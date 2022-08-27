package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.LaborPersonalObra;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("laborPersonalObraRepository")
public interface ILaborPersonalObraRepository extends JpaRepository<LaborPersonalObra, Long> {

}
