package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import com.registro_clinica.registro_clinica_app.entities.Medico;

public interface MedicoService {
List<Medico> findAll();
Medico save (Medico medico);
Optional<Medico> update (Long id, Medico medico);
Optional<Medico> delete (Long id);
Optional<Medico> findById(Long id);
Optional<Medico> findByApellido(String apellido);

}
