package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
