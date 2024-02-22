package com.registro_clinica.registro_clinica_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro_clinica.registro_clinica_app.entities.Medico;
import com.registro_clinica.registro_clinica_app.entities.Paciente;
import com.registro_clinica.registro_clinica_app.entities.Turno;
import com.registro_clinica.registro_clinica_app.repositories.IMedicoRepository;
import com.registro_clinica.registro_clinica_app.repositories.IPacienteRepository;
import com.registro_clinica.registro_clinica_app.repositories.ITurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService{

    @Autowired
    private ITurnoRepository repository;
    @Autowired
    private IMedicoRepository repositoryMedico;
    @Autowired
    private IPacienteRepository repositoryPaciente;


    @Transactional(readOnly = true)
    @Override
    public List<Turno> findAll() {
        return (List<Turno>) repository.findAll();
    }

    @Transactional
    @Override
    public Turno save(Turno turno) {
        Optional<Medico> medico = repositoryMedico.findByApellido(turno.getMedico().getApellido());
        Optional<Paciente> paciente = repositoryPaciente.findByDni(turno.getPaciente().getDni());
        medico.ifPresent(m ->{
            turno.setMedico(m);
        });
        paciente.ifPresent(p->{
            turno.setPaciente(p);
        });
        return repository.save(turno);
    }

    @Override
    public Optional<Turno> update(Long id, Turno turno) {
        Optional<Turno> turnoOptional = findById(id);
        if(turnoOptional.isPresent()){
            Turno turnoDb = turnoOptional.orElseThrow();
            turnoDb.setFecha(turno.getFecha());
            return Optional.of(repository.save(turnoDb));
        }
        return turnoOptional;
        
    }

    @Override
    public Optional<Turno> delete(Long id) {
        Optional<Turno> turnoOptional = findById(id);
        turnoOptional.ifPresent(turno ->{
            repository.delete(turno);
        });
        return turnoOptional;
    }

    @Override
    public Optional<Turno> findById(Long id) {
        return repository.findById(id);
    }
   
}
