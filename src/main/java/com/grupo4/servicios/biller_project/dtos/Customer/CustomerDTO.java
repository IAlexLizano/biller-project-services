package com.grupo4.servicios.biller_project.dtos.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private Long customer_id;
    
    private Long idTypeId;

    private String customerDni;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phoneNumber;
}
