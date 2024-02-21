package com.registro_clinica.registro_clinica_app.entities;


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
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=30)
    private String nombre;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=30)
    private String apellido;
    @OneToOne
    private EspecialidadMedico especialidad;

    public Medico(){
    }
    
    public Medico(Long id, String nombre, String apellido, EspecialidadMedico especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
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

    public EspecialidadMedico getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadMedico especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad
                + "]";
    }
    
}
