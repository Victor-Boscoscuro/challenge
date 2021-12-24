package com.challenge.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Integer id;

    @Column(unique = true,nullable = false)
    private Integer dni;
    private String nombre;
    private String apellido;
    private boolean es_empleado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public boolean isEs_empleado() {
        return es_empleado;
    }

    public void setEs_empleado(boolean es_empleado) {
        this.es_empleado = es_empleado;
    }
}
