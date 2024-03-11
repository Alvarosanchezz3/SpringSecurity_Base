package com.alvaro.springsecurity.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SaveProduct implements Serializable {

    @NotBlank(message = "El campo name es requerido")
    private String name;

    @DecimalMin(value = "0.01", message = "El campo precio debe de ser mayor de 0")
    private BigDecimal price;

    @Min(value = 1, message = "El campo categoryId debe ser mayor de 0")
    private Long categoryId;
}

