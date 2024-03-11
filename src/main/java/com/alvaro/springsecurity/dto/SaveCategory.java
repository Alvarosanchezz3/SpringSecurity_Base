package com.alvaro.springsecurity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaveCategory implements Serializable {

    @NotBlank(message = "El campo name es requerido")
    private String name;

}
