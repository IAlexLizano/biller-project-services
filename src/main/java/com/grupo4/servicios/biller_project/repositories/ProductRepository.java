package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.Product;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDeletedStatusFalse(Sort sort);
    boolean existsByCode(String code);
}
