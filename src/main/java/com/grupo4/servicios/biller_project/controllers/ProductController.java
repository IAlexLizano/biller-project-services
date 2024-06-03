package com.grupo4.servicios.biller_project.controllers;

import com.grupo4.servicios.biller_project.dtos.product.ProductResponseDto;
import com.grupo4.servicios.biller_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductResponseDto productResponseDTO) {
        ProductResponseDto createdProduct = productService.createProduct(productResponseDTO);
        return ResponseEntity.created(URI.create("/products/" + createdProduct.getProductId())).body(createdProduct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductResponseDto productResponseDTO) throws Exception {
        ProductResponseDto updatedProduct = productService. updateProduct(id, productResponseDTO);
        return ResponseEntity.ok().body(updatedProduct);
    }
}

