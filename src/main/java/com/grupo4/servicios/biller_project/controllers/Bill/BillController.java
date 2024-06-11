package com.grupo4.servicios.biller_project.controllers.Bill;

import com.grupo4.servicios.biller_project.dtos.bill.BillCreateDto;
import com.grupo4.servicios.biller_project.dtos.bill.BillDTO;
import com.grupo4.servicios.biller_project.services.Bill.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;


    @GetMapping("/{id}")
    public ResponseEntity<BillDTO> getBillById(@PathVariable Long id) {
        Optional<BillDTO> bill = billService.getBillById(id);
        return bill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BillDTO createBill(@Valid @RequestBody BillCreateDto billCreateDto) {
        return billService.createBill(billCreateDto);
    }


}
