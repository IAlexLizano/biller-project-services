package com.grupo4.servicios.biller_project.dtos.bill;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailCreateDto;
@Data
public class BillCreateDto {        

    @NotNull(message="La factura debe contener productos")
    private List<BillDetailCreateDto> detalles;
}
