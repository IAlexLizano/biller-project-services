package com.grupo4.servicios.biller_project.dtos.product;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCreateDto {
    private Long categoryId;

    @NotBlank(message = "El código del producto no puede estar en blanco")
    @Size(min = 6, max = 6, message = "El codigo proporcionado no es válido")
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
