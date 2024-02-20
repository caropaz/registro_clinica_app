package com.registro_clinica.registro_clinica_app.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Integer edad;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @OneToOne(mappedBy = "paciente")
    private HistoriaClinica historiaClinica;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String dni, Integer edad, Domicilio domicilio,
            HistoriaClinica historiaClinica) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.domicilio = domicilio;
        this.historiaClinica = historiaClinica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad="
                + edad + ", domicilio=" + domicilio + ", historiaClinica=" + historiaClinica + "]";
    }

}
