package com.example.proyectoFinalDeborah.controllers;

import com.example.proyectoFinalDeborah.entity.User;
import com.example.proyectoFinalDeborah.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/me")
    public User getCurrentUser(HttpServletRequest request) {
        // Obtener el usuario actual del atributo establecido por el interceptor JWT
        return (User) request.getAttribute("currentUser");
    }
}