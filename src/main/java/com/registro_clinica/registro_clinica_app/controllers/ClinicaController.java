package com.registro_clinica.registro_clinica_app.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.registro_clinica.registro_clinica_app.entities.Paciente;
import com.registro_clinica.registro_clinica_app.services.PacienteService;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {

    @Autowired
    private PacienteService service;
    @GetMapping("/")
    public String home(){
        return "Pagina Principal";
    }

    @GetMapping("/listar")
    public List<Paciente> listarPacientes(){
        return service.findAll();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> findByDni(@PathVariable String dni){
        Optional<Paciente> pacienteOptional = service.findByDni(dni);
        if(pacienteOptional.isPresent()){
            return ResponseEntity.ok(pacienteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paciente));
    }
   
}
