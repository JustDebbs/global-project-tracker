package com.example.proyectoFinalDeborah.repo;

import com.example.proyectoFinalDeborah.DTO.CreateProjectDto;
import com.example.proyectoFinalDeborah.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
    List<Project> findByIdManager(Long id);

}

