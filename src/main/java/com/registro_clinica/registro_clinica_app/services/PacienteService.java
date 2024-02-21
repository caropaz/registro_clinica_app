package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import com.registro_clinica.registro_clinica_app.entities.Paciente;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente save (Paciente paciente);
    boolean existsByDni (String dni);
    Optional<Paciente> findByDni(String dni);
    Optional<Paciente> findById(Long id);
    Optional<Paciente> update (Long id, Paciente paciente);
    Optional<Paciente> delete (Long id);
}

