package com.example.proyectoFinalDeborah.controllers;

import com.example.proyectoFinalDeborah.entity.user;
import com.example.proyectoFinalDeborah.services.userService;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class userControllers {
    @Autowired
    private userService userServices;
    @GetMapping
    public List<user> getAllUsers() {
        return userServices.findAll();
    }
}
