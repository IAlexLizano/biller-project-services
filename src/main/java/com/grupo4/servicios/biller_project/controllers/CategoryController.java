package com.grupo4.servicios.biller_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.servicios.biller_project.entities.Category;
import com.grupo4.servicios.biller_project.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories(); 
    }
}