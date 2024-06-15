package com.grupo4.servicios.biller_project.controllers.Bill;

import com.grupo4.servicios.biller_project.dtos.bill.BillCreateDto;
import com.grupo4.servicios.biller_project.dtos.bill.BillDTO;
import com.grupo4.servicios.biller_project.entities.Bill;
import com.grupo4.servicios.biller_project.services.Bill.BillService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;


    @GetMapping
    public List<BillDTO> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        try {
            return billService.getBillById(id);
        } catch (Exception e) {
            throw new RuntimeException("El cliente no existe");
        }
    }

    @PostMapping
    public Bill createBill(@Valid @RequestBody BillCreateDto billCreateDto) {
        return billService.createBill(billCreateDto);
    }


}
