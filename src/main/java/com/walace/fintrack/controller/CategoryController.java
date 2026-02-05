package com.walace.fintrack.controller;

import com.walace.fintrack.dto.CreateCategoryDTO;
import com.walace.fintrack.dto.UpdateCategoryDTO;
import com.walace.fintrack.domain.Category;
import com.walace.fintrack.dto.CategoryDTO;
import com.walace.fintrack.mapper.CategoryMapper;
import com.walace.fintrack.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;


// @RestController = Controller + @ResponseBody
// Tudo que retorna aqui vira resposta HTTP (JSON, por padrão)
@RestController
public class CategoryController {

    // DEPENDÊNCIA: o Controller precisa do Service
    private final CategoryService categoryService;

    // CONSTRUTOR: Spring injeta automaticamente o Service aqui
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET /categories
    @GetMapping("/categories")
    public List<CategoryDTO> listCategories() {

        // 1. Service retorna domínio
        List<Category> categories = categoryService.listCategories();

        // 2. Converte domínio -> DTO
        return categories.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    // POST /categories
    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO createCategory(@Valid @RequestBody CreateCategoryDTO request) {

        // 1) Controller pega o dado do contrato (DTO de entrada)
        String name = request.getName();

        // 2) Controller chama o service passando só o necessário (domínio)
        var created = categoryService.createCategory(name);

        // 3) Converte domínio -> DTO de saída
        return CategoryMapper.toDTO(created);
    }

    // PUT /categories/{id}
    @PutMapping("/categories/{id}")
    public CategoryDTO updateCategory(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCategoryDTO request
    ) {
        // 1) chama o service (domínio)
        var updated = categoryService.updateCategory(id, request.getName());

        // 2) converte para DTO de saída
        return CategoryMapper.toDTO(updated);
    }

    // DELETE /categories/{id}
    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void deleteCategory(@PathVariable Integer id) {

        // chama o service para deletar
        categoryService.deleteCategory(id);

        // retorna vazio (204 = sem corpo)
    }


}
