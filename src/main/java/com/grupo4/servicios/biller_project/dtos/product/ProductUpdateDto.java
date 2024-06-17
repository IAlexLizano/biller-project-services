package com.grupo4.servicios.biller_project.dtos.product;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductUpdateDto {
    
    private Long categoryId;
    private String code;

    @NotBlank(message = "El nombre del producto no puede estar en blanco")
    @Size(min = 3, message = "El nombre no es válido")
    private String name;

    private String image;

    @NotBlank(message = "Agregue una descripción")
    private String description;

    @Positive(message = "El precio no puede ser cero ni menor al mismo")
    private BigDecimal unitPrice;

    @PositiveOrZero(message = "El stock de productos debe ser 0 o mayor")
    private Integer stock;
}
