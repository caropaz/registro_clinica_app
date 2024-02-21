package com.registro_clinica.registro_clinica_app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "historiaclinica")
    private List<AtencionMedica> atencionMedica;
    
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public HistoriaClinica(){

    }
    
    public HistoriaClinica(Long id, List<AtencionMedica> atencionMedica, Paciente paciente) {
        this.id = id;
        this.atencionMedica = atencionMedica;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<AtencionMedica> getAtencionMedica() {
        return atencionMedica;
    }

    public void setAtencionMedica(List<AtencionMedica> atencionMedica) {
        this.atencionMedica = atencionMedica;
    }

    @Override
    public String toString() {
        return "HistoriaClinica [id=" + id + ", atencionMedica=" + atencionMedica + ", paciente=" + paciente + "]";
    }
    
    
}
