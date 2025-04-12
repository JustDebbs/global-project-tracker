package com.example.proyectoFinalDeborah.controllers;

import com.example.proyectoFinalDeborah.entity.Task;
import com.example.proyectoFinalDeborah.entity.User;
import com.example.proyectoFinalDeborah.services.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping("/user")
    public List<Task> getTasksByCurrentUser(HttpServletRequest request) {
        User currentUser = (User) request.getAttribute("currentUser");
        return taskService.findByUserId(currentUser.getId());
    }

    @GetMapping("/project/{projectId}")
    public List<Task> getTasksByProject(@PathVariable Long projectId) {
        return taskService.findByProjectId(projectId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, HttpServletRequest request) {
        // Obtener el usuario actual del atributo establecido por el interceptor JWT
        User currentUser = (User) request.getAttribute("currentUser");

        // Crear la tarea asociada al usuario actual
        return taskService.createTask(task, currentUser);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}