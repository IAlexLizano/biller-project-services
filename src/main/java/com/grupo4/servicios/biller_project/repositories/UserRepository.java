package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aquí puedes agregar métodos adicionales de consulta si es necesario
}
