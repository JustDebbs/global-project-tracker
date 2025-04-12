package com.example.proyectoFinalDeborah.repo;

import com.example.proyectoFinalDeborah.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    // Método para buscar tareas por el ID del usuario
    List<Task> findByUserId(Long userId);

    // Método para buscar tareas por el ID del proyecto
    List<Task> findByIdProject(Long idProject);
}