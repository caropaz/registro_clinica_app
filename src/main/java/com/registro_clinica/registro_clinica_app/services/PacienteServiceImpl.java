package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.Paciente;
import com.registro_clinica.registro_clinica_app.repositories.IPacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private IPacienteRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
       return (List<Paciente>) repository.findAll();
    }

    @Transactional
    @Override
    public Paciente save(Paciente paciente) {
       return repository.save(paciente);
    }

   @Override
   public boolean existsByDni(String dni) {
            return repository.existsByDni(dni);
   }

   @Override
   public Optional<Paciente> findByDni(String dni) {
      return repository.findByDni(dni);
   }

}
