package com.alvaro.springsecurity.persistence.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public enum ProductStatus {
        ENABLED, DISABLED // Los valores serían 0 y 1
    }

    @ManyToOne // Muchos productos iran asociados a una categoría
    @JoinColumn(name = "category_id") // Atributo category_id que tendrá una llave foránea con categoría
    private Category category;
}
