package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.Usuario;
import com.registro_clinica.registro_clinica_app.repositories.IUsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = repository.findByUsername(username);
        
        if(usuarioOptional.isEmpty()){
            throw new UsernameNotFoundException(String.format("El username %s no existe en el sistema!",username));
        }
        Usuario usuario = usuarioOptional.orElseThrow();

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getNombre()))
        .collect(Collectors.toList());

        return new User(usuario.getUsername(), 
        usuario.getPassword(),
        usuario.getEnabled(),
        true,
        true,
        true,
        authorities);
        
    }

}
