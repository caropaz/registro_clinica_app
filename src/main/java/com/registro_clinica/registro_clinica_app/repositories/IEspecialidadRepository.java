package com.registro_clinica.registro_clinica_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.registro_clinica.registro_clinica_app.entities.EspecialidadMedico;

public interface IEspecialidadRepository extends CrudRepository<EspecialidadMedico,Long>{
    Optional<EspecialidadMedico> findByNombre(String nombre);

}
