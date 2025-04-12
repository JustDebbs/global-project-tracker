package com.example.proyectoFinalDeborah.controllers;



import com.example.proyectoFinalDeborah.DTO.AuthResponse;
import com.example.proyectoFinalDeborah.DTO.LoginRequest;
import com.example.proyectoFinalDeborah.DTO.RegisterRequest;
import com.example.proyectoFinalDeborah.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request, HttpServletResponse response) {
        AuthResponse authResponse = userService.register(request);

        // Configurar cookie con el token JWT
        addTokenCookie(response, authResponse.getToken());

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        AuthResponse authResponse = userService.login(request);

        // Configurar cookie con el token JWT
        addTokenCookie(response, authResponse.getToken());

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        // Eliminar cookie de JWT
        Cookie cookie = new Cookie("jwt", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok("Sesión cerrada correctamente");
    }

    private void addTokenCookie(HttpServletResponse response, String token) {
        // Configurar cookie con el token JWT
        Cookie cookie = new Cookie("jwt", token);
        cookie.setMaxAge(86400); // 24 horas
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}