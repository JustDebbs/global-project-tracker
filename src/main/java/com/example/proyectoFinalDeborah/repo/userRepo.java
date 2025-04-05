package com.example.proyectoFinalDeborah.repo;

import com.example.proyectoFinalDeborah.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user, Long> {
}
