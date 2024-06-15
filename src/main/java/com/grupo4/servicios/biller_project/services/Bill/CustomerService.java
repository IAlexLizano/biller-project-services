package com.grupo4.servicios.biller_project.services.Bill;

import com.grupo4.servicios.biller_project.dtos.Customer.CustomerCreateDto;
import com.grupo4.servicios.biller_project.dtos.Customer.CustomerDTO;
import com.grupo4.servicios.biller_project.entities.Customer;
import com.grupo4.servicios.biller_project.repositories.CustomerRepository;
import com.grupo4.servicios.biller_project.repositories.IdTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IdTypeRepository idTypeRepository;

    @Transactional(readOnly = true)
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        try {
            return customer.orElseThrow(() -> new Exception("El cliente no existe"));
        } catch (Exception e) {
            throw new RuntimeException("El cliente no existe");
        }
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerCreateDto customerCreateDto) {
        Customer customer = convertToEntity(customerCreateDto);
        Customer savedCustomer = customerRepository.save(customer);
        return convertToDTO(savedCustomer);
    }



    private CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(
            customer.getCustomerId(),
            customer.getIdType().getTypeId(),
            customer.getCustomerDni(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getAddress(),
            customer.getPhoneNumber()
        );
    }

    private Customer convertToEntity(CustomerCreateDto customerCreateDto) {
        Customer customer = new Customer();
        customer.setIdType(idTypeRepository.findById(customerCreateDto.getIdTypeId()).orElseThrow());
        customer.setCustomerDni(customerCreateDto.getCustomerDni());
        customer.setFirstName(customerCreateDto.getFirstName());
        customer.setLastName(customerCreateDto.getLastName());
        customer.setEmail(customerCreateDto.getEmail());
        customer.setAddress(customerCreateDto.getAddress());
        customer.setPhoneNumber(customerCreateDto.getPhoneNumber());
        return customer;
    }
}
