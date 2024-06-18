package com.grupo4.servicios.biller_project.controllers.Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.grupo4.servicios.biller_project.dtos.Customer.CustomerCreateDto;
import com.grupo4.servicios.biller_project.entities.Customer;
import com.grupo4.servicios.biller_project.services.Bill.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        try {
            return customerService.getCustomerById(id);
        } catch (Exception e) {
            throw new RuntimeException("El cliente no existe");
        }
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody CustomerCreateDto customerCreateDto) {
        return customerService.createCustomer(customerCreateDto);
    }
}