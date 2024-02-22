package com.registro_clinica.registro_clinica_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.registro_clinica.registro_clinica_app.entities.Medico;

public interface IMedicoRepository extends CrudRepository<Medico, Long> {
    Optional<Medico> findByApellido(String apellido);
}
