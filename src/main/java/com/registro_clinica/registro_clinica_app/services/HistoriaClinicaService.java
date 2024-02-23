package com.registro_clinica.registro_clinica_app.services;

import java.util.Optional;

import com.registro_clinica.registro_clinica_app.entities.AtencionMedica;
import com.registro_clinica.registro_clinica_app.entities.HistoriaClinica;

public interface HistoriaClinicaService {

    Optional<HistoriaClinica> findById(Long id);
    Optional<HistoriaClinica> update(Long id, AtencionMedica atencionMedica);
}
