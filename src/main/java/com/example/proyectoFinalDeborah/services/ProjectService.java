package com.example.proyectoFinalDeborah.services;

import com.example.proyectoFinalDeborah.entity.Project;
import com.example.proyectoFinalDeborah.entity.Task;
import com.example.proyectoFinalDeborah.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired //Instanciar directamente la clase
    private ProjectRepo projectRepo;

    public List<Project> findByUserId(Long idManger) {
        return projectRepo.findByIdManager(idManger);
    }


}
