package com.grupo4.servicios.biller_project.dtos.BillDetail;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BillDetailCreateDto {

    @NotNull(message = "El ID de la factura no puede estar en blanco")
    private Long bill; 

    @NotNull(message = "El ID del producto no puede estar en blanco")
    private Long product;

    @NotNull(message = "la cantidad del producto no puede estar en blanco")
    private Integer quantity;
}   
