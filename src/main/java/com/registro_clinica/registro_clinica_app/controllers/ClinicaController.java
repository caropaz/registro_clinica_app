package com.registro_clinica.registro_clinica_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
