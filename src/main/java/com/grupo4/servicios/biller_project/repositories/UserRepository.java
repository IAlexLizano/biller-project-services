package com.grupo4.servicios.biller_project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.servicios.biller_project.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    Optional<User> findByUsername(String username);

}
