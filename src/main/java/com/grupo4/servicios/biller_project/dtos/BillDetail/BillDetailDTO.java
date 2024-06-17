package com.grupo4.servicios.biller_project.dtos.BillDetail;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class BillDetailDTO {
    
private Long bill;
    private Long product;
    private String productName;
    private BigDecimal productUnitPrice;
    private Integer quantity;
}
