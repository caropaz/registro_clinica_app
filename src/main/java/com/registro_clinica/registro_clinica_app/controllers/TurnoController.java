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

import com.registro_clinica.registro_clinica_app.entities.Turno;
import com.registro_clinica.registro_clinica_app.services.TurnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turno")
public class TurnoController {
@Autowired
    private TurnoService service;
    

    @GetMapping("/listar")
    public List<Turno> listarTurnos(){
        return service.findAll();
    }
    @PostMapping
    public ResponseEntity<?> registrarTurno(@Valid @RequestBody Turno turno, BindingResult result){
         if(result.hasFieldErrors()){
            return ResponseEntity.badRequest().body("No se pudo registrar el Turno");
         }
         Turno turnoGuardado = service.save(turno);
         if(turnoGuardado == null){
            return ResponseEntity.badRequest().body("No se pudo procesar por informacion incorrecta");
         }
         return ResponseEntity.status(HttpStatus.CREATED).body(turnoGuardado);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTurno (@Valid @RequestBody Turno turno, BindingResult result, @PathVariable Long id){
        if(result.hasFieldErrors()){
            return ResponseEntity.badRequest().body("No se pudo actualizar el turno");
        }
        Optional<Turno> turnoOptional = service.update(id, turno);

        if (turnoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(turnoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> eliminarTurno(@PathVariable Long id){
        Optional<Turno> turnoOptional = service.delete(id);
        if(turnoOptional.isPresent()){
            return ResponseEntity.ok(turnoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
