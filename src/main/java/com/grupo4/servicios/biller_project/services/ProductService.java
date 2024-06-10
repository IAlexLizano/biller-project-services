package com.grupo4.servicios.biller_project.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grupo4.servicios.biller_project.entities.Product;
import com.grupo4.servicios.biller_project.repositories.CategoryRepository;
import com.grupo4.servicios.biller_project.repositories.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;
    
    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper,
            CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findByDeletedStatusFalse(Sort.by(Sort.Direction.ASC, "productId"));
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        try {
            return (product.orElseThrow(() -> new Exception("El producto no existe")));
        } catch (Exception e) {
            throw new RuntimeException("El producto no existe");
        }
    }
}
