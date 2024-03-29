package com.registro_clinica.registro_clinica_app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=30)
    private String calle;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=30)
    private String numero;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=30)
    private String ciudad;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=30)
    private String provincia;
    
    @JsonIgnore
    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

    public Domicilio(){

    }
    
    public Domicilio(Long id, String calle, String numero, String ciudad, String provincia, Paciente paciente) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    @Override
    public String toString() {
        return "Domicilio [id=" + id + ", calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", provincia="
                + provincia + "]";
    }

    
}
