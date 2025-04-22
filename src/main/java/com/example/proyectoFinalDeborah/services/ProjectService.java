package com.example.proyectoFinalDeborah.services;

import com.example.proyectoFinalDeborah.DTO.CreateProjectDto;
import com.example.proyectoFinalDeborah.entity.Project;
import com.example.proyectoFinalDeborah.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> findByUserId(Long idManager) {
        return projectRepo.findByIdManager(idManager);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        Optional<Project> project = projectRepo.findById(id);
        return project.orElse(null);
    }

    public Project createProject(CreateProjectDto projectDto) {
        // Crear una instancia completa con constructor
        Project project = new Project(
                0, // El ID se generará automáticamente
                projectDto.getName(),
                projectDto.getDepartment(),
                projectDto.getDescription(),
                projectDto.getGeography(),
                projectDto.getStartDate(),
                projectDto.getEndDate(),
                projectDto.getIdManager()
        );

        return projectRepo.save(project);
    }

    public Project updateProject(Long id, CreateProjectDto projectDto) {
        Optional<Project> existingProjectOpt = projectRepo.findById(id);

        if (existingProjectOpt.isPresent()) {
            // Crear una nueva instancia con los valores actualizados y el ID existente
            Project existingProject = existingProjectOpt.get();
            Project updatedProject = new Project(
                    existingProject.getId(),
                    projectDto.getName(),
                    projectDto.getDepartment(),
                    projectDto.getDescription(),
                    projectDto.getGeography(),
                    projectDto.getStartDate(),
                    projectDto.getEndDate(),
                    projectDto.getIdManager()
            );

            return projectRepo.save(updatedProject);
        }

        return null;
    }

    public boolean deleteProject(Long id) {
        Optional<Project> project = projectRepo.findById(id);

        if (project.isPresent()) {
            projectRepo.deleteById(id);
            return true;
        }

        return false;
    }
}