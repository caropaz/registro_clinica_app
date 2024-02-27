package com.registro_clinica.registro_clinica_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.registro_clinica.registro_clinica_app.entities.Usuario;
import java.util.Optional;


public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
    Optional<Usuario>  findByUsername(String username);
    Optional <Usuario> findById(Long id);
}
