package com.alvaro.springsecurity.service;

import com.alvaro.springsecurity.dto.SaveProduct;
import com.alvaro.springsecurity.persistence.entitiy.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

    Product create(SaveProduct saveProduct);

    Product updateOneById(Long productId, SaveProduct saveProduct);

    Product disableOneById (Long productId);

    Product enableOneById (Long productId);

}
