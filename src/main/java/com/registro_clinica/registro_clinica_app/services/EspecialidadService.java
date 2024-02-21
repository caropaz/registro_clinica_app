package com.registro_clinica.registro_clinica_app.services;

import java.util.Optional;

import com.registro_clinica.registro_clinica_app.entities.EspecialidadMedico;


public interface EspecialidadService {
     Optional<EspecialidadMedico> findById(Long id);
     Optional<EspecialidadMedico> findByNombre(String nombre);


}
