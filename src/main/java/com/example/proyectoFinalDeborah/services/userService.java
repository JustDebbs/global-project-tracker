package com.example.proyectoFinalDeborah.services;

import com.example.proyectoFinalDeborah.entity.user;
import com.example.proyectoFinalDeborah.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class userService {
    @Autowired
    private userRepo userRepository;




    public List<user> findAll() {
        return userRepository.findAll();
    }
}
