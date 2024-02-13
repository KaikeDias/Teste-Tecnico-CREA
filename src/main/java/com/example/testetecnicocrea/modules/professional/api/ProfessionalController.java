package com.example.testetecnicocrea.modules.professional.api;

import com.example.testetecnicocrea.modules.professional.domain.entities.*;
import com.example.testetecnicocrea.modules.professional.domain.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/professionals")
@RestController
public class ProfessionalController {
    @Autowired
    private ProfessionalRepository professionalRepository;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        try {
            var professionals = professionalRepository.findAll();

            return ResponseEntity.ok(professionals);
        } catch (Exception e) {
            System.err.println("Erro ao buscar profissionais: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar profissionais: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        try {
            var professional = professionalRepository.findById(id);

            return ResponseEntity.ok(professional);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createProfessional(@RequestBody ProfessionalDTO professionalDTO) {
        try {
            var professionalId = professionalRepository.save(professionalDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(professionalId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PatchMapping("{professionalId}/titles/{titleId}")
    public ResponseEntity<Object> addTitle(@PathVariable int professionalId, @PathVariable int titleId) {
        try {
            professionalRepository.addTitle(professionalId, titleId);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @DeleteMapping("{professionalId}/titles/{titleId}")
    public ResponseEntity<Object> removeTitleFromProfessional(@PathVariable int professionalId,
                                                              @PathVariable int titleId) {
        try {
            professionalRepository.removeTitleFromProfessional(titleId, professionalId);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PatchMapping("/professional_type/{id}")
    public ResponseEntity<Object> updateProfessionalTypeVisado(@PathVariable int id,
                                                               @RequestBody ProfessionalTypeUpdateDTO professionalTypeUpdateDTO) {
        try {
            professionalRepository.updateProfessionalTypeToVisado(id, professionalTypeUpdateDTO.visaDate());

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteAll() {
        try {
            professionalRepository.deleteAll();

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        try {
            professionalRepository.deleteById(id);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> updateProfessional(@RequestBody Professional professional) {
        try {
            int titleId = professionalRepository.update(professional);

            return ResponseEntity.ok(titleId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<Object> updateProfessionalStatus(@PathVariable int id,
                                                           @RequestBody ProfessionalStatusUpdateDTO professionalStatusUpdateDTO) {
        try {

            professionalRepository.updateProfessionalStatus(id, professionalStatusUpdateDTO.registrationStatus());

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

}
