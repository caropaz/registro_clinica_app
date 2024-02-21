package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.Domicilio;
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

    @Transactional(readOnly =true)
   @Override
   public Optional<Paciente> findById(Long id) {
      return repository.findById(id);
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

   @Transactional
   @Override
   public Optional<Paciente> update (Long id, Paciente paciente) {
      
      Optional<Paciente> pacienteOptional = repository.findById(id);
      
      if(pacienteOptional.isPresent()){

         Paciente pacienteDb = pacienteOptional.orElseThrow();
         pacienteDb.setNombre(paciente.getNombre());
         pacienteDb.setApellido(paciente.getApellido() !=null ?paciente.getApellido() : pacienteDb.getApellido());
         pacienteDb.setDni(paciente.getDni()!=null ? paciente.getDni() : pacienteDb.getDni());
         pacienteDb.setEdad(paciente.getEdad()!=null ? paciente.getEdad() :pacienteDb.getEdad());

         Domicilio domicilioDb = pacienteDb.getDomicilio();
         domicilioDb.setCalle(paciente.getDomicilio().getCalle());
         domicilioDb.setCiudad(paciente.getDomicilio().getCiudad());
         domicilioDb.setNumero(paciente.getDomicilio().getNumero());
         domicilioDb.setProvincia(paciente.getDomicilio().getProvincia());
         
         pacienteDb.setDomicilio(domicilioDb);
         return Optional.of(repository.save(pacienteDb));
      }
      return pacienteOptional;
   }


   @Transactional
   @Override
   public Optional<Paciente> delete(Long id) {
      Optional<Paciente> pacienteOptional  = repository.findById(id);
      pacienteOptional.ifPresent(paciente ->{
         repository.delete(paciente);
      });
      return pacienteOptional;
   }

   
}
