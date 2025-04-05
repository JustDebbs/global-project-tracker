package com.example.proyectoFinalDeborah.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

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
}
