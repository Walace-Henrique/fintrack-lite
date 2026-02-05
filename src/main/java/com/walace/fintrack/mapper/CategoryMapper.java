package com.walace.fintrack.mapper;

import com.walace.fintrack.domain.Category;
import com.walace.fintrack.dto.CategoryDTO;

// Mapper = camada de conversão (domínio -> DTO)
public class CategoryMapper {

    // static porque o mapper não precisa guardar estado (não tem atributos)
    public static CategoryDTO toDTO(Category category) {

        // Converte o objeto do domínio para o DTO (contrato)
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }
}
