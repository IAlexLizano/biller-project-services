package com.grupo4.servicios.biller_project.services.Bill;

import com.grupo4.servicios.biller_project.dtos.Customer.CustomerCreateDto;
import com.grupo4.servicios.biller_project.dtos.Customer.CustomerDTO;
import com.grupo4.servicios.biller_project.entities.Customer;
import com.grupo4.servicios.biller_project.repositories.CustomerRepository;
import com.grupo4.servicios.biller_project.repositories.IdTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IdTypeRepository idTypeRepository;


    public Optional<CustomerDTO> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).map(this::convertToDTO);
    }

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
