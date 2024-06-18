package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerDni(String customerDni);
}
