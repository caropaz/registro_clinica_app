package com.registro_clinica.registro_clinica_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.HistoriaClinica;
import com.registro_clinica.registro_clinica_app.repositories.IHistoriaClinicaRepository;


@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService{
    @Autowired
    private IHistoriaClinicaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Optional<HistoriaClinica> findById(Long id) {
        return repository.findById(id);
    }


}
