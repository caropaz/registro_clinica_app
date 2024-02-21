package com.registro_clinica.registro_clinica_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro_clinica.registro_clinica_app.entities.Medico;
import com.registro_clinica.registro_clinica_app.services.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping("/listar")
    public List<Medico> listarMedicos(){
        return service.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> registrarPaciente(@Valid @RequestBody Medico medico, BindingResult result){
        if(result.hasFieldErrors()){
            return ResponseEntity.badRequest().body("No se pudo crear el medico");
        }
        Medico medicoGuardado = service.save(medico);
        if (medicoGuardado == null){
            return ResponseEntity.badRequest().body("La informacion ingresada es incorrecta, intente nuevamente");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoGuardado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMedico(@Valid @RequestBody Medico medico, BindingResult result, @PathVariable Long id){
        
        if(result.hasFieldErrors()){
            return ResponseEntity.badRequest().body("No se pudo procesar la actualizacion");
        }
        
        Optional<Medico> medicoOptional = service.update(id,medico);
        if (medicoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(medicoOptional.orElseThrow());
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medico> eliminarMedico(@PathVariable Long id){
        Optional<Medico> medicoOptional = service.delete(id);
        if (medicoOptional.isPresent()) {
            return ResponseEntity.ok(medicoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
