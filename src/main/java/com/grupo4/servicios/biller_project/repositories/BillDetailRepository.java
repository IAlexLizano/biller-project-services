package com.grupo4.servicios.biller_project.repositories;

import com.grupo4.servicios.biller_project.entities.BillDetail;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
    // Aquí puedes agregar métodos adicionales de consulta si es necesario
    List<BillDetail> findByBill_BillId(Long billId);

}
