package com.grupo4.servicios.biller_project.services.Bill;

import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailCreateDto;
import com.grupo4.servicios.biller_project.dtos.bill.BillCreateDto;
import com.grupo4.servicios.biller_project.dtos.bill.BillDTO;
import com.grupo4.servicios.biller_project.entities.Bill;
import com.grupo4.servicios.biller_project.entities.BillDetail;
import com.grupo4.servicios.biller_project.repositories.BillDetailRepository;
import com.grupo4.servicios.biller_project.repositories.BillRepository;
import com.grupo4.servicios.biller_project.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Autowired
    private CustomerService customerService;
    
    @Transactional(readOnly = true)
    public List<BillDTO> getAllBills(){
       List<Bill> bills = billRepository.findAll(Sort.by(Sort.Direction.ASC, "billId"));
       List<BillDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billDTOs.add(convertToDTO(bill));
        }
        return billDTOs;
    }

    @Transactional(readOnly = true)
    public Bill getBillById(Long billId) {
        Optional<Bill> bill = billRepository.findById(billId);
        try {
            return bill.orElseThrow(() -> new Exception("La factura no existe"));
        } catch (Exception e) {
            throw new RuntimeException("La factura no existe");
        }
    }

    @Transactional
    public Bill createBill(BillCreateDto billCreateDto) {
        Bill bill = new Bill();
        Long idCustomer = 0L;
        bill.setCustomer(customerService.getCustomerById(idCustomer));
        Bill savedBill = billRepository.save(bill);
        for (BillDetailCreateDto details : billCreateDto.getDetalles()){
            BillDetail detail = new BillDetail();
            detail.setBill(savedBill);
            detail.setProduct(productService.getProductById(details.getProduct()));
            detail.setQuantity(details.getQuantity());
            billDetailRepository.save(detail);
        }
        return savedBill;
    }


    private BillDTO convertToDTO(Bill bill) {
        BillDTO billDTO = new BillDTO();
        billDTO.setBillId(bill.getBillId());
        billDTO.setCustomer(bill.getCustomer());
        billDTO.setNumber(bill.getNumber());
        billDTO.setDateBill(bill.getDateBill());
        billDTO.setTotal(bill.getTotal());
        billDTO.setSubtotal(bill.getSubtotal());
        billDTO.setDetalle(billDetailRepository.findByBill_BillId(bill.getBillId()));
        return billDTO;
    }
}
