package com.walace.fintrack.dto;

import jakarta.validation.constraints.NotBlank;

// DTO DE ENTRADA (request)
public class CreateCategoryDTO {

    // @NotBlank: não permite null, "" ou "   "
    @NotBlank(message = "O campo 'name' é obrigatório.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
