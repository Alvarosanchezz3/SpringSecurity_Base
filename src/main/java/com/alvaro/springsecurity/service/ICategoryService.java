package com.alvaro.springsecurity.service;

import com.alvaro.springsecurity.dto.SaveCategory;
import com.alvaro.springsecurity.persistence.entitiy.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findOneById(Long categoryId);

    Category create(SaveCategory saveProduct);

    Category updateOneById(Long categoryId, SaveCategory saveCategory);

    Category disableOneById(Long productId);

    Category enableOneById(Long categoryId);
}
