package com.example.testetecnicocrea.modules.professional.domain.repositories;

import com.example.testetecnicocrea.modules.professional.domain.entities.Professional;
import com.example.testetecnicocrea.modules.professional.domain.entities.ProfessionalDTO;
import com.example.testetecnicocrea.modules.professional.domain.entities.RegistrationStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfessionalRepository {
    int save(ProfessionalDTO professionalDTO);

    int update(Professional professional);

    Professional findById(int id);

    int deleteById(int id);

    List<Professional> findAll();

    int deleteAll();

    void addTitle(int titleId, int professionalId);

    void updateProfessionalTypeToVisado(int professionalId, LocalDateTime visaDate);

    void removeTitleFromProfessional(int titleId, int professionalId);

    void updateProfessionalStatus(int id, RegistrationStatus status);
}
