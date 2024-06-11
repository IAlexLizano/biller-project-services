package com.grupo4.servicios.biller_project.dtos.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerCreateDto {


    @NotNull(message = "El tipo de identificación no puede estar en blanco")
    private Long idTypeId;

    @NotBlank(message = "El DNI del cliente no puede estar en blanco")
    @Size(min = 10, max = 13, message = "El DNI debe tener 8 caracteres")
    private String customerDni;

    @NotBlank(message = "El nombre del cliente no puede estar en blanco")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido del cliente no puede estar en blanco")
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres")
    private String lastName;

    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @NotBlank(message = "La dirección no puede estar en blanco")
    private String address;

    @NotBlank(message = "El número de teléfono no puede estar en blanco")
    @Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener 10 dígitos")
    private String phoneNumber;
}
