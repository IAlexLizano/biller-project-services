package com.grupo4.servicios.biller_project.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.grupo4.servicios.biller_project.entities.Category;
import com.grupo4.servicios.biller_project.repositories.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryId"));
    }
}