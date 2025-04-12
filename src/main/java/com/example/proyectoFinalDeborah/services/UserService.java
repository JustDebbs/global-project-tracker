package com.example.proyectoFinalDeborah.services;


import com.example.proyectoFinalDeborah.DTO.AuthResponse;
import com.example.proyectoFinalDeborah.DTO.LoginRequest;
import com.example.proyectoFinalDeborah.DTO.RegisterRequest;
import com.example.proyectoFinalDeborah.entity.User;
import com.example.proyectoFinalDeborah.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private JwtService jwtService;

    // Encuentra todos los usuarios
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Registra un nuevo usuario
    public AuthResponse register(RegisterRequest request) {
        // Verificar si el email ya está en uso
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El email ya está registrado");
        }

        // Crear nuevo usuario
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // En un entorno real, deberías encriptar la contraseña
        user.setRoleId(request.getRoleId());

        // Guardar usuario
        User savedUser = userRepository.save(user);

        // Generar token JWT
        String token = jwtService.generateToken(savedUser.getEmail(), savedUser.getId());

        return new AuthResponse(token, "Usuario registrado correctamente");
    }

    // Login de usuario
    public AuthResponse login(LoginRequest request) {
        // Buscar usuario por email
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        User user = userOptional.get();

        // Verificar contraseña
        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        // Generar token JWT
        String token = jwtService.generateToken(user.getEmail(), user.getId());

        return new AuthResponse(token, "Login exitoso");
    }

    // Valida un token JWT
    public User validateToken(String token) {
        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token no proporcionado");
        }

        // Extraer email del token
        String email = jwtService.extractEmail(token);

        // Buscar usuario por email
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado");
        }

        User user = userOptional.get();

        // Validar token
        if (!jwtService.isTokenValid(token, email)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido o expirado");
        }

        return user;
    }

}
