package com.grupo4.servicios.biller_project.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grupo4.servicios.biller_project.dtos.product.ProductCreateDto;
import com.grupo4.servicios.biller_project.dtos.product.ProductUpdateDto;
import com.grupo4.servicios.biller_project.entities.Category;
import com.grupo4.servicios.biller_project.entities.Product;
import com.grupo4.servicios.biller_project.repositories.CategoryRepository;
import com.grupo4.servicios.biller_project.repositories.ProductRepository;
import com.grupo4.servicios.biller_project.utils.GoogleDriveService;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;
    private GoogleDriveService googleDriveService;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper,
                          CategoryRepository categoryRepository, GoogleDriveService googleDriveService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.googleDriveService = googleDriveService;
    }

    public Product convertToEntity(ProductCreateDto productCreateDto) {
        Product product = modelMapper.map(productCreateDto, Product.class);
        Category category = categoryRepository.findById(productCreateDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        product.setCategory(category);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findByDeletedStatusFalse(Sort.by(Sort.Direction.ASC, "productId"));
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        try {
            return product.orElseThrow(() -> new Exception("El producto no existe"));
        } catch (Exception e) {
            throw new RuntimeException("El producto no existe");
        }
    }

    public ResponseEntity<String> createProduct(ProductCreateDto productData) {
        try {
            Product product = convertToEntity(productData);
            if (productRepository.existsByCode(productData.getCode())) {
                throw new RuntimeException("El código del producto debe ser único");
            }

            if (productData.getImage() != null) {
                String imageUrl = googleDriveService.uploadFile(productData.getImage(), "image/jpeg", productData.getCode());
                product.setImage(imageUrl);
            }

            productRepository.save(product);
            return ResponseEntity.ok("El producto se creó con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
        }
    }

    public ResponseEntity<String> updateProduct(Long id, ProductUpdateDto productUpdateData) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new Exception("Product not found with id: " + id));

            if (productUpdateData.getCategoryId() != null) {
                Category category = categoryRepository.findById(productUpdateData.getCategoryId())
                        .orElseThrow(() -> new Exception("Categoría no encontrada"));
                existingProduct.setCategory(category);
            }

            if (productUpdateData.getName() != null) {
                existingProduct.setName(productUpdateData.getName());
            }

            if (productUpdateData.getImage() != null) {
                String imageUrl = googleDriveService.uploadFile(productUpdateData.getImage(), "image/jpeg", existingProduct.getCode());
                existingProduct.setImage(imageUrl);
            }

            if (productUpdateData.getDescription() != null) {
                existingProduct.setDescription(productUpdateData.getDescription());
            }

            if (productUpdateData.getUnitPrice() != null) {
                existingProduct.setUnitPrice(productUpdateData.getUnitPrice());
            }

            if (productUpdateData.getStock() != null) {
                existingProduct.setStock(productUpdateData.getStock());
            }

            productRepository.save(existingProduct);
            return ResponseEntity.ok("El producto fue modificado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
        }
    }

    public ResponseEntity<String> deleteProduct(Long id) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new Exception("El producto no existe"));
            existingProduct.setDeletedStatus(true);
            productRepository.save(existingProduct);

            return ResponseEntity.ok("El producto fue eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el producto");
        }
    }
}
