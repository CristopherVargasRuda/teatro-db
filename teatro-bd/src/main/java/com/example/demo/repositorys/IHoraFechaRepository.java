package com.example.demo.repositorys;

import org.springframework.stereotype.Repository;

import com.example.demo.models.HoraFecha;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("horaFechaRepository")
public interface IHoraFechaRepository extends JpaRepository<HoraFecha, LocalTime> {

}
