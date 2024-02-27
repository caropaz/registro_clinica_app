package com.registro_clinica.registro_clinica_app.services;

import java.util.Optional;

import com.registro_clinica.registro_clinica_app.entities.Usuario;

public interface UsuarioService {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findById(Long id);
    Usuario save (Usuario usuario);
    Optional<Usuario> update (Long id, Usuario usuario);
    Optional<Usuario> delete (Long id);
}
