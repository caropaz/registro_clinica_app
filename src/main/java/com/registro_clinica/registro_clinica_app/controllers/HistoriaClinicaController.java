package com.registro_clinica.registro_clinica_app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro_clinica.registro_clinica_app.entities.AtencionMedica;
import com.registro_clinica.registro_clinica_app.entities.HistoriaClinica;
import com.registro_clinica.registro_clinica_app.services.HistoriaClinicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/historiaclinica")
public class HistoriaClinicaController {

    @Autowired
    HistoriaClinicaService service;


    @GetMapping("/{id}")
    public  ResponseEntity<?> findById(@PathVariable Long id){
        Optional<HistoriaClinica>  historiaOptional = service.findById(id);
        if (historiaOptional.isPresent()){
            return ResponseEntity.ok(historiaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> agregarAtencionClinica(@Valid @RequestBody AtencionMedica atencionMedica, BindingResult result, @PathVariable Long id){
        if(result.hasFieldErrors()){
            return ResponseEntity.badRequest().body("No se pudo agregar la atencion Clinica");
        }
        Optional<HistoriaClinica> historiaOptional = service.update(id, atencionMedica);
        if (historiaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(historiaOptional);
        }
        return ResponseEntity.notFound().build();
    }
}
