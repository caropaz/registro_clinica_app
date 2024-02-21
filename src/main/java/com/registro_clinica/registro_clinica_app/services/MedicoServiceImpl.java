package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.EspecialidadMedico;
import com.registro_clinica.registro_clinica_app.entities.Medico;
import com.registro_clinica.registro_clinica_app.repositories.IEspecialidadRepository;
import com.registro_clinica.registro_clinica_app.repositories.IMedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private IMedicoRepository repository;

    @Autowired
    private IEspecialidadRepository repositoryEspecialidad;

    @Transactional
    @Override
    public List<Medico> findAll() {
        return (List<Medico>) repository.findAll();
    }

    private EspecialidadMedico verificarEspecialidad(String nombre){
        Optional<EspecialidadMedico> especialidadOptional= repositoryEspecialidad.findByNombre(nombre);
        if (especialidadOptional.isPresent()){
            EspecialidadMedico especialidad = especialidadOptional.orElseThrow();
            return especialidad;
        }
        return null;
    }

    @Override
    public Medico save(Medico medico) {
        EspecialidadMedico especialidad= verificarEspecialidad(medico.getEspecialidad().getNombre());
        if(especialidad != null){
            medico.setEspecialidad(especialidad);
        return repository.save(medico);
        }
        return null;
    }

    @Override
    public Optional<Medico> update(Long id, Medico medico) {
        Optional<Medico> medicoOptional = repository.findById(id);
        EspecialidadMedico especialidadMedico = verificarEspecialidad(medico.getEspecialidad().getNombre());

        if (medicoOptional.isPresent() && especialidadMedico != null) {
            Medico medicoDb = medicoOptional.orElseThrow();
            medicoDb.setNombre(medico.getNombre());
            medicoDb.setApellido(medico.getApellido());
            medicoDb.setEspecialidad(especialidadMedico);
            repository.save(medicoDb);
        return medicoOptional;

        }
        return medicoOptional= null;
    }

    @Transactional
    @Override
    public Optional<Medico> delete(Long id) {
        Optional<Medico> medicoOptional = repository.findById(id);
        medicoOptional.ifPresent(medico ->{
            repository.delete(medico);
        });
        return medicoOptional;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Medico> findById(Long id) {
        return repository.findById(id);
    }

}
