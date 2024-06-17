package com.grupo4.servicios.biller_project.services.Bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.servicios.biller_project.entities.IdType;
import com.grupo4.servicios.biller_project.repositories.IdTypeRepository;

@Service
public class IdTypeService {
    @Autowired
    private IdTypeRepository idTypeRepository;

    public List<IdType> getIdTypes(){
        return idTypeRepository.findAll();
    }
}
