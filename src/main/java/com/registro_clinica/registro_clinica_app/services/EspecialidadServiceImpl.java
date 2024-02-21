package com.registro_clinica.registro_clinica_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.EspecialidadMedico;
import com.registro_clinica.registro_clinica_app.repositories.IEspecialidadRepository;


public class EspecialidadServiceImpl implements EspecialidadService{

    @Autowired
    private IEspecialidadRepository repository;

    @Transactional(readOnly =true)
    @Override
    public Optional<EspecialidadMedico> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly =true)
    @Override
    public Optional<EspecialidadMedico> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

}
