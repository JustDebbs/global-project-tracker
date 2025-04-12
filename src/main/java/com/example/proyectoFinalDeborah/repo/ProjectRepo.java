package com.example.proyectoFinalDeborah.repo;

import com.example.proyectoFinalDeborah.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long UserId);

}

