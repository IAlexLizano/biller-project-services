package com.grupo4.servicios.biller_project.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "id_types")
public class IdType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "type", nullable = false)
    private String type;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
