package com.registro_clinica.registro_clinica_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro_clinica.registro_clinica_app.entities.Usuario;
import com.registro_clinica.registro_clinica_app.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    private ResponseEntity<?> crearUsuario (@Valid @RequestBody Usuario usuario, BindingResult result){
        if(result.hasFieldErrors()){
            return  ResponseEntity.badRequest().body("No se pudo registrar al usuario");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult result){
        usuario.setAdmin(false);
        return crearUsuario(usuario, result);
    }
    
}
