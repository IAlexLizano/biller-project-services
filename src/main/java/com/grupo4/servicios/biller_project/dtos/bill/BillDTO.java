package com.grupo4.servicios.biller_project.dtos.bill;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.grupo4.servicios.biller_project.entities.BillDetail;
import com.grupo4.servicios.biller_project.entities.Customer;

@Data
public class BillDTO {
    private Long billId;
    private String number;
    private Date dateBill;
    private BigDecimal subtotal;
    private BigDecimal total;
    private Customer customer;
    private List<BillDetail> detalle;
}
