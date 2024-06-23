package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}

