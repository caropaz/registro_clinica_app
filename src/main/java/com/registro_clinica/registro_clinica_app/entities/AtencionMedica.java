package com.registro_clinica.registro_clinica_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atenciones_medicas")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detalle;
    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne()
    @JoinColumn(name = "historiaclinica_id")
    private HistoriaClinica historiaclinica;

    public AtencionMedica() {
    }

    public AtencionMedica(Long id, String detalle, Medico medico) {
        this.id = id;
        this.detalle = detalle;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "AtencionMedica [id=" + id + ", detalle=" + detalle + ", medico=" + medico + "]";
    }

}
