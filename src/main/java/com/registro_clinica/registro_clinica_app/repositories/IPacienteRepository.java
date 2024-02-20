package com.registro_clinica.registro_clinica_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registro_clinica.registro_clinica_app.entities.Paciente;

public interface IPacienteRepository extends CrudRepository<Paciente, Long> {

}
