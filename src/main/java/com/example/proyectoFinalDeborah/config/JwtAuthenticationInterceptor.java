package com.example.proyectoFinalDeborah.config;

import com.example.proyectoFinalDeborah.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.server.ResponseStatusException;

@Component
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Verificar si es una ruta pública (login o registro)
        String path = request.getRequestURI();
        if (isPublicPath(path)) {
            return true;
        }

        // Obtener token de las cookies
        String token = extractTokenFromCookies(request);

        // Si no hay token en las cookies, buscar en el header Authorization
        if (token == null) {
            token = extractTokenFromHeader(request);
        }

        try {
            // Validar token y establecer el usuario en el atributo de la solicitud
            request.setAttribute("currentUser", userService.validateToken(token));
            return true;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Acceso no autorizado: " + e.getMessage());
        }
    }

    private boolean isPublicPath(String path) {
        return path.contains("/api/auth/login") ||
                path.contains("/api/auth/register") ||
                path.contains("/api/public");
    }

    private String extractTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}