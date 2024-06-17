package com.grupo4.servicios.biller_project.dtos.bill;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailCreateDto;
import com.grupo4.servicios.biller_project.dtos.Customer.CustomerCreateDto;

@Data
public class BillCreateDto {        
    @NotNull
    private BigDecimal subtotal;

    @NotNull
    private BigDecimal total;

    private CustomerCreateDto customer;

    @NotNull(message="La factura debe contener productos")
    private List<BillDetailCreateDto> detalles;
}
