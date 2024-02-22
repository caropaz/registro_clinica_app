package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import com.registro_clinica.registro_clinica_app.entities.Turno;

public interface TurnoService {

    List<Turno> findAll();
    Turno save(Turno turno);
    Optional<Turno> update (Long id, Turno turno);
    Optional<Turno> delete (Long id);
    Optional<Turno> findById(Long id);
}
