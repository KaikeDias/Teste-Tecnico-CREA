package com.example.testetecnicocrea.modules.title.domain.entities;

import jakarta.validation.constraints.NotBlank;

public record TitleDTO(
        @NotBlank
        String description
) {

}
