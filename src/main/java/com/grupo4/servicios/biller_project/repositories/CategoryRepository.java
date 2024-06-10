package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll(Sort sort);
}
