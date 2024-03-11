package com.alvaro.springsecurity.persistence.repository;

import com.alvaro.springsecurity.persistence.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
