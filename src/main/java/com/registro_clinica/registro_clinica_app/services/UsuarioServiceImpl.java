package com.registro_clinica.registro_clinica_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.Usuario;
import com.registro_clinica.registro_clinica_app.repositories.IUsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Transactional
    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioDb = usuarioOptional.orElseThrow();
            usuarioDb.setPassword(usuario.getPassword());
            usuarioDb.setRoles(usuario.getRoles());
            usuarioDb.setUsername(usuario.getUsername());
            
            return Optional.of(repository.save(usuario));
        }
        return usuarioOptional;
    }

    @Override
    public Optional<Usuario> delete(Long id) {
        Optional<Usuario> usuarioOptional = findById(id);

        usuarioOptional.ifPresent(
            u -> {
                repository.delete(u);
            });
        return usuarioOptional;
    }

}
