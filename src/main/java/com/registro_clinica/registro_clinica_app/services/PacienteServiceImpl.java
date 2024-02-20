package com.registro_clinica.registro_clinica_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro_clinica.registro_clinica_app.entities.Paciente;
import com.registro_clinica.registro_clinica_app.repositories.IPacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private IPacienteRepository repository;

    @Override
    public List<Paciente> findAll() {
       return (List<Paciente>) repository.findAll();
    }

    @Override
    public Paciente save(Paciente paciente) {
       return repository.save(paciente);
    }

}
