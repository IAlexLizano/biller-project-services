package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.IdType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdTypeRepository extends JpaRepository<IdType, Long> {
}
