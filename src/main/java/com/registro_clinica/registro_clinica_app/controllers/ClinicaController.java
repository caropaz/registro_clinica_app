package com.registro_clinica.registro_clinica_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {

    @GetMapping("/")
    public String home(){
        return "Pagina Principal";
    }
}
