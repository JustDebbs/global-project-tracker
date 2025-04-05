package com.example.proyectoFinalDeborah.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Task")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long idProject;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String fechaInicio;

    @Column(nullable = false)
    private String fechaExigida;
}

