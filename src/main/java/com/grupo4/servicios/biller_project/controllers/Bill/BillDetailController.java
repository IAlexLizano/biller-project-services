package com.grupo4.servicios.biller_project.controllers.Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailCreateDto;
import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailDTO;
import com.grupo4.servicios.biller_project.services.Bill.BillDetailService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/bill-details")
public class BillDetailController {

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<BillDetailDTO> getBillDetailById(@PathVariable Long id) {
        Optional<BillDetailDTO> billDetail = billDetailService.getBillDetailById(id);
        return billDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/bill/{billId}")
    public ResponseEntity<List<BillDetailDTO>> getBillDetailsByBillId(@PathVariable Long billId) {
        List<BillDetailDTO> billDetails = billDetailService.getBillDetailsByBillId(billId);
        return ResponseEntity.ok(billDetails);
    }

    @PostMapping
    public ResponseEntity<BillDetailDTO> createBillDetail(@Valid @RequestBody BillDetailCreateDto billDetailCreateDto) {
        BillDetailDTO createdBillDetail = billDetailService.createBillDetail(billDetailCreateDto);
        return ResponseEntity.ok(createdBillDetail);
    }
}
