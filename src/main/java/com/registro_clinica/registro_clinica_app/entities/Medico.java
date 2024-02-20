package com.registro_clinica.registro_clinica_app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico {

    private Long id;
    private String nombre;
    private String apellido;
    @OneToMany
    @JoinTable(name = "especialidad_id" )
    private List<EspecialidadMedico> especialidades;

    public Medico(){
    }
    public Medico(Long id, String nombre, String apellido, List<EspecialidadMedico> especialidades) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidades = especialidades;
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
    public List<EspecialidadMedico> getEspecialidades() {
        return especialidades;
    }
    public void setEspecialidades(List<EspecialidadMedico> especialidades) {
        this.especialidades = especialidades;
    }
    @Override
    public String toString() {
        return "Medico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidades="
                + especialidades + "]";
    }
}
