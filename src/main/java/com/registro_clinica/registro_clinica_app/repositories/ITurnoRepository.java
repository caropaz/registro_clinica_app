package com.registro_clinica.registro_clinica_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.registro_clinica.registro_clinica_app.entities.Turno;

public interface ITurnoRepository extends CrudRepository<Turno,Long> {
    Optional<Turno> findById(Long id);
}
