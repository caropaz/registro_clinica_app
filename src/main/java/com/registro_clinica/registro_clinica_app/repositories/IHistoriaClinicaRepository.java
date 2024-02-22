package com.registro_clinica.registro_clinica_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.registro_clinica.registro_clinica_app.entities.HistoriaClinica;

public interface IHistoriaClinicaRepository extends CrudRepository<HistoriaClinica,Long>{
    Optional<HistoriaClinica> findById(Long id);
}
