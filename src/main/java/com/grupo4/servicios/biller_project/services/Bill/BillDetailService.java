package com.grupo4.servicios.biller_project.services.Bill;

import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailCreateDto;
import com.grupo4.servicios.biller_project.dtos.BillDetail.BillDetailDTO;
import com.grupo4.servicios.biller_project.entities.BillDetail;
import com.grupo4.servicios.biller_project.repositories.BillDetailRepository;
import com.grupo4.servicios.biller_project.repositories.BillRepository;
import com.grupo4.servicios.biller_project.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillDetailService {

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductRepository productRepository;

    public Optional<BillDetailDTO> getBillDetailById(Long billDetailId) {
        return billDetailRepository.findById(billDetailId).map(this::convertToDTO);
    }

    public List<BillDetailDTO> getBillDetailsByBillId(Long billId) {
        List<BillDetail> billDetails = billDetailRepository.findByBill_BillId(billId);
        return billDetails.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public BillDetailDTO createBillDetail(BillDetailCreateDto billDetailCreateDto) {
        BillDetail billDetail = convertToEntity(billDetailCreateDto);
        BillDetail savedBillDetail = billDetailRepository.save(billDetail);
        return convertToDTO(savedBillDetail);
    }

    private BillDetailDTO convertToDTO(BillDetail billDetail) {
        BillDetailDTO billDetailDTO = new BillDetailDTO();
        billDetailDTO.setBillDetail_id(billDetail.getBillDetail_id());
        billDetailDTO.setBill(billDetail.getBill().getBillId());
        billDetailDTO.setProduct(billDetail.getProduct().getProductId());
        billDetailDTO.setQuantity(billDetail.getQuantity());
        return billDetailDTO;
    }

    private BillDetail convertToEntity(BillDetailCreateDto billDetailCreateDto) {
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(billRepository.findById(billDetailCreateDto.getBill()).orElseThrow());
        billDetail.setProduct(productRepository.findById(billDetailCreateDto.getProduct()).orElseThrow());
        billDetail.setQuantity(billDetailCreateDto.getQuantity());
        return billDetail;
    }
}
