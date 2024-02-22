package com.registro_clinica.registro_clinica_app.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @NotNull(message = "La fecha no debe ser nula")
    @Future(message = "La fecha debe estar en el futuro")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",  timezone = "America/Argentina/Buenos_Aires")
    private Date fecha;

    public Turno() {
    }

    public Turno(Long id, Medico medico, Paciente paciente, Date fecha) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Turno [id=" + id + ", medico=" + medico + ", paciente=" + paciente + ", fecha=" + fecha + "]";
    }

}
