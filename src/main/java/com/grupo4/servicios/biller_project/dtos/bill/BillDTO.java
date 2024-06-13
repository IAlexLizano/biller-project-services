package com.grupo4.servicios.biller_project.dtos.bill;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BillDTO {
    private Long billId;
    private Long userId;
    private Long customerId;
    private String number;
    private Date dateBill;
    private BigDecimal total;
}
