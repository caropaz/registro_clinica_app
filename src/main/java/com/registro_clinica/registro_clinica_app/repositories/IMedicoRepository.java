package com.registro_clinica.registro_clinica_app.repositories;

import org.springframework.data.repository.CrudRepository;
import com.registro_clinica.registro_clinica_app.entities.Medico;

public interface IMedicoRepository extends CrudRepository<Medico, Long> {

}
