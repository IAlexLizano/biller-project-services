package com.grupo4.servicios.biller_project.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "number", nullable = false)
    private String number;
    
    @Column(name = "date_bill", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateBill;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "total", nullable = false)
    private BigDecimal total;
   }
