package com.grupo4.servicios.biller_project.services;
import com.grupo4.servicios.biller_project.dtos.product.ProductResponseDto;
import com.grupo4.servicios.biller_project.entities.Product;
import com.grupo4.servicios.biller_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProductResponseDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return convertToDTO(product.orElse(null));
    }

    private ProductResponseDto convertToDTO(Product product) {
        ProductResponseDto productResponseDTO = new ProductResponseDto();
        productResponseDTO.setCategoryId(product.getCategory().getCategoryId());
        productResponseDTO.setCode(product.getCode());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setUnitPrice(product.getUnitPrice());
        productResponseDTO.setStock(product.getStock());
        return productResponseDTO;
    }

    public ProductResponseDto createProduct(ProductResponseDto productResponseDTO) {
        Product product = convertToEntity(productResponseDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    private Product convertToEntity(ProductResponseDto productResponseDTO) {
        Product product = new Product();
        // Mapear campos de DTO a entidad
        return product;
    }

    public ProductResponseDto updateProduct(Long id, ProductResponseDto productResponseDTO) throws Exception {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));

        existingProduct.setCode(productResponseDTO.getCode());
        existingProduct.setName(productResponseDTO.getName());
        existingProduct.setImage(productResponseDTO.getImage());
        existingProduct.setDescription(productResponseDTO.getDescription());
        existingProduct.setUnitPrice(productResponseDTO.getUnitPrice());
        existingProduct.setStock(productResponseDTO.getStock());

        Product updatedProduct = productRepository.save(existingProduct);
        return convertToDTO(updatedProduct);
    }
}
