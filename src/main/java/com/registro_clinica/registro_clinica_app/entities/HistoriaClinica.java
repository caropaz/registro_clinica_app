package com.registro_clinica.registro_clinica_app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "historiaclinica")
    private List<AtencionMedica> atencionMedica;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",  timezone = "America/Argentina/Buenos_Aires")
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    public HistoriaClinica(){
        this.atencionMedica = new ArrayList<>();
        this.fechaCreacion = new Date();
    }
    
    
    public HistoriaClinica(Long id,  Paciente paciente) {
        this.id = id;
        this.atencionMedica = new ArrayList<>();
        this.paciente = paciente;
        this.fechaCreacion = new Date();
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


    public Date getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    @Override
    public String toString() {
        return "HistoriaClinica [id=" + id + ", atencionMedica=" + atencionMedica + ", paciente=" + paciente
                + ", fechaCreacion=" + fechaCreacion + "]";
    }
    
    
}
