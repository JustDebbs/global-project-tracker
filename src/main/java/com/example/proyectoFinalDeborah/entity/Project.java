package com.example.proyectoFinalDeborah.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "description")
    private String description;

    @Column(name = "geography")
    private String geography;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "startDate")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "idManager")
    private Long idManager;

    // Constructor sin argumentos
    public Project() {
    }

    // Constructor con todos los argumentos
    public Project(long id, String name, String department, String description, String geography, Date startDate, Date endDate, Long idManager) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.description = description;
        this.geography = geography;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idManager = idManager;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public String getGeography() {
        return geography;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Long getIdManager() {
        return idManager;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }
}