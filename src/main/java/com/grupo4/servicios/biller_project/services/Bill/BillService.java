package com.grupo4.servicios.biller_project.services.Bill;

import com.grupo4.servicios.biller_project.dtos.bill.BillCreateDto;
import com.grupo4.servicios.biller_project.dtos.bill.BillDTO;
import com.grupo4.servicios.biller_project.entities.Bill;
import com.grupo4.servicios.biller_project.repositories.BillRepository;
import com.grupo4.servicios.biller_project.repositories.CustomerRepository;
import com.grupo4.servicios.biller_project.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<BillDTO> getBillById(Long billId) {
        return billRepository.findById(billId).map(this::convertToDTO);
    }

    public BillDTO createBill(BillCreateDto billCreateDto) {
        Bill bill = convertToEntity(billCreateDto);
        Bill savedBill = billRepository.save(bill);
        return convertToDTO(savedBill);
    }


    private BillDTO convertToDTO(Bill bill) {
        BillDTO billDTO = new BillDTO();
        billDTO.setBillId(bill.getBillId());
        billDTO.setUserId(bill.getUser().getUserId());
        billDTO.setCustomerId(bill.getCustomer().getCustomerId());
        billDTO.setNumber(bill.getNumber());
        billDTO.setDateBill(bill.getDateBill());
        billDTO.setTotal(bill.getTotal());
        return billDTO;
    }

    private Bill convertToEntity(BillCreateDto billCreateDto) {
        Bill bill = new Bill();
        bill.setUser(userRepository.findById(billCreateDto.getUserId()).orElseThrow());
        bill.setCustomer(customerRepository.findById(billCreateDto.getCustomerId()).orElseThrow());
        bill.setTotal(billCreateDto.getTotal());
        return bill;
    }
}
