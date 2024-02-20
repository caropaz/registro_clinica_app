package com.registro_clinica.registro_clinica_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registro_clinica.registro_clinica_app.entities.Paciente;
import java.util.Optional;


public interface IPacienteRepository extends CrudRepository<Paciente, Long> {
    boolean existsByDni(String dni);
    Optional<Paciente> findByDni(String dni);
}
