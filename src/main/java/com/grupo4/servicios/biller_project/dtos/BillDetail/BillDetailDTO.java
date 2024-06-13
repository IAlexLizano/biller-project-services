package com.grupo4.servicios.biller_project.dtos.BillDetail;

import lombok.Data;


@Data
public class BillDetailDTO {
    
    private Long billDetail_id;
    private Long bill;
    private Long product;
    private Integer quantity;
}
