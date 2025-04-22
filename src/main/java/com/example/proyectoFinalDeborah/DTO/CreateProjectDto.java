package com.example.proyectoFinalDeborah.DTO;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectDto {
    private String name;
    private String description;
    private String department;
    private String geography;
    private Date startDate;
    private Date endDate;
    private Long idManager;
}