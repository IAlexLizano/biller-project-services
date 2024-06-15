package com.grupo4.servicios.biller_project.dtos.BillDetail;

import lombok.Data;


@Data
public class BillDetailDTO {
    
    private Long bill;
    private Long product;
    private Integer quantity;
}
