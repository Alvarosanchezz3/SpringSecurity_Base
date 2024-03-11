package com.alvaro.springsecurity.service.impl;

import com.alvaro.springsecurity.dto.SaveCategory;
import com.alvaro.springsecurity.exception.ObjectNotFoundException;
import com.alvaro.springsecurity.persistence.entitiy.Category;
import com.alvaro.springsecurity.persistence.repository.CategoryRepository;
import com.alvaro.springsecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category create(SaveCategory saveCategory) {
        Category category = new Category();
            category.setName(saveCategory.getName());
            category.setStatus(Category.CategoryStatus.ENABLED);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
        Category categoryFromDb = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with id " + categoryId));

        categoryFromDb.setName(saveCategory.getName());

        return categoryRepository.save(categoryFromDb);
    }

    @Override
    public Category disableOneById(Long categoryId) {
        Category categoryFromDb = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with id " + categoryId));

        categoryFromDb.setStatus(Category.CategoryStatus.DISABLED);

        return categoryRepository.save(categoryFromDb);
    }

    @Override
    public Category enableOneById(Long categoryId) {
        Category categoryFromDb = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with id " + categoryId));

        categoryFromDb.setStatus(Category.CategoryStatus.ENABLED);

        return categoryRepository.save(categoryFromDb);
    }

}