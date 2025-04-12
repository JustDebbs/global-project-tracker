package com.example.proyectoFinalDeborah.services;

import com.example.proyectoFinalDeborah.entity.Task;
import com.example.proyectoFinalDeborah.entity.User;
import com.example.proyectoFinalDeborah.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    // Obtener todas las tareas
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    // Obtener tareas por usuario
    public List<Task> findByUserId(Long userId) {
        return taskRepo.findByUserId(userId);
    }

    // Obtener tareas por proyecto
    public List<Task> findByProjectId(Long projectId) {
        return taskRepo.findByIdProject(projectId);
    }

    // Obtener tarea por ID
    public Task findById(Long id) {
        Optional<Task> task = taskRepo.findById(id);
        if (task.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        return task.get();
    }

    // Crear nueva tarea
    public Task createTask(Task task, User user) {
        // Asignar el usuario que crea la tarea
        task.setUserId(user.getId());
        return taskRepo.save(task);
    }

    // Actualizar tarea
    public Task updateTask(Long id, Task taskDetails) {
        Task task = findById(id);

        // Actualizar los campos
        task.setName(taskDetails.getName());
        task.setDescripcion(taskDetails.getDescripcion());
        task.setEstado(taskDetails.getEstado());
        task.setFechaInicio(taskDetails.getFechaInicio());
        task.setFechaExigida(taskDetails.getFechaExigida());

        return taskRepo.save(task);
    }

    // Eliminar tarea
    public void deleteTask(Long id) {
        Task task = findById(id);
        taskRepo.delete(task);
    }
}
