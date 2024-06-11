package com.grupo4.servicios.biller_project.dtos.bill;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillCreateDto {

    @NotNull(message = "El ID del usuario no puede estar en blanco")
    private Long userId;

    @NotNull(message = "El ID del cliente no puede estar en blanco")
    private Long customerId;

    @NotNull(message = "El total de la factura no puede estar en blanco")
    private BigDecimal total;
}
