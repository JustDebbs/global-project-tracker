package com.example.proyectoFinalDeborah.controllers;

import com.example.proyectoFinalDeborah.entity.Project;
import com.example.proyectoFinalDeborah.entity.Task;
import com.example.proyectoFinalDeborah.entity.User;
import com.example.proyectoFinalDeborah.services.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/user")
    public List<Project> getProjectsByCurrentUser(HttpServletRequest request) {
        User currentUser = (User) request.getAttribute("currentUser");
        return projectService.findByUserId(currentUser.getId());
    }
}
