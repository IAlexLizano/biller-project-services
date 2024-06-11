package com.grupo4.servicios.biller_project.controllers;

import com.grupo4.servicios.biller_project.dtos.product.ProductCreateDto;
import com.grupo4.servicios.biller_project.dtos.product.ProductUpdateDto;
import com.grupo4.servicios.biller_project.entities.Product;
import com.grupo4.servicios.biller_project.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        try {
            return productService.getProductById(id);
        } catch (Exception e) {
            throw new RuntimeException("El producto no existe");
        }
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductCreateDto productData) {
        try {
            return productService.createProduct(productData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateProduct(@Valid @PathVariable Long id,
            @RequestBody ProductUpdateDto productResponseDTO) {
        try {
            return productService.updateProduct(id, productResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}

