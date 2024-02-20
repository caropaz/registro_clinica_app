package com.registro_clinica.registro_clinica_app.services;

import java.util.List;

import com.registro_clinica.registro_clinica_app.entities.Paciente;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente save (Paciente paciente);
}
