package com.example.proyectoFinalDeborah.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String name;

    @Getter
    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String geografia;

    @Column(nullable = false)
    private String fechaInicio;

    @Column(nullable = false)
    private String fechaExigida;

    @Column(nullable = false)
    private long idManager;

    public Project(){
    }

    public Project (String name, String departamento, String geografía, String fechaInicio, String fechaExigida, long idManager){
        this.name = name;
        this.departamento = departamento;
        this.geografia = geografia;
        this.fechaInicio = fechaInicio;
        this.fechaExigida = fechaExigida;
        this.idManager = idManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getGeografia() {
        return geografia;
    }

    public void setGeografia(String geografia) {
        this.geografia = geografia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaExigida() {
        return fechaExigida;
    }

    public void setFechaExigida(String fechaExigida) {
        this.fechaExigida = fechaExigida;
    }


    public long getIdManager() {
        return idManager;
    }

    public void setIdManager(long idManager) {
        this.idManager = idManager;
    }
}


