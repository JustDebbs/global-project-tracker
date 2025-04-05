package com.example.proyectoFinalDeborah.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private long roleId;
}
