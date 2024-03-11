package com.alvaro.springsecurity.persistence.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING) // Cambiamos de los valores 0 y 1 a los textos ENABLED y DISABLED
    private CategoryStatus status;

    public enum CategoryStatus {
        ENABLED, DISABLED // Los valores serían 0 y 1
    }
}

