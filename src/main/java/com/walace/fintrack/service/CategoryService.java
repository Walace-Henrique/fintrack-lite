package com.walace.fintrack.service;

import com.walace.fintrack.domain.Category;
import com.walace.fintrack.exception.ResourceNotFoundException;
import com.walace.fintrack.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Spring injeta o Repository
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Agora vem do banco
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    // Agora salva no banco e devolve com ID gerado
    public Category createCategory(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer id, String name) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com id " + id + " não encontrada"));

        category.setName(name);

        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {

        // Confere se existe antes de deletar (pra devolver 404 bonito)
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria com id " + id + " não encontrada");
        }

        categoryRepository.deleteById(id);
    }

}
