package com.grupo4.servicios.biller_project.controllers.Bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.servicios.biller_project.entities.IdType;
import com.grupo4.servicios.biller_project.services.Bill.IdTypeService;

@RestController
@RequestMapping("/api/idtypes")
public class IdTypeController {
    @Autowired
    private IdTypeService idTypeService;

    @GetMapping()
    public List<IdType> getIdTypes(){
        return idTypeService.getIdTypes();
    }
}
