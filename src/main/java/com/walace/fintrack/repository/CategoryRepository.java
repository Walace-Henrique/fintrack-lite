package com.walace.fintrack.repository;

import com.walace.fintrack.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository já traz: save(), findAll(), findById(), deleteById()...
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
