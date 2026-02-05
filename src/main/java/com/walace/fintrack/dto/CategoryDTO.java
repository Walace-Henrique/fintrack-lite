package com.walace.fintrack.dto;

// DTO = objeto de transporte (contrato da API)
public class CategoryDTO {

    private final int id;
    private final String name;

    // CONSTRUTOR: DTO nasce pronto
    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
