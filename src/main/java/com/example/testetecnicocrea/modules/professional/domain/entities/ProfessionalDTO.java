package com.example.testetecnicocrea.modules.professional.domain.entities;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ProfessionalDTO(
        String name,
        String email,
        String password,
        LocalDate birthDate,
        String phoneNumber,
        ProfessionalType professionalType
) {
}
