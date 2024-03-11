package com.alvaro.springsecurity.service.impl;

import com.alvaro.springsecurity.dto.SaveProduct;
import com.alvaro.springsecurity.exception.ObjectNotFoundException;
import com.alvaro.springsecurity.persistence.entitiy.Category;
import com.alvaro.springsecurity.persistence.entitiy.Product;
import com.alvaro.springsecurity.persistence.repository.ProductRepository;
import com.alvaro.springsecurity.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOneById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product create(SaveProduct saveProduct) {
        Product product = new Product();
            product.setName(saveProduct.getName());
            product.setPrice(saveProduct.getPrice());
            product.setStatus(Product.ProductStatus.ENABLED);

        Category category = new Category();
            category.setId(saveProduct.getCategoryId());
            product.setCategory(category);

            return productRepository.save(product);
    }

    @Override
    public Product updateOneById(Long productId, SaveProduct saveProduct) {

        Product productFromDb = productRepository.findById(productId).orElseThrow(
                () -> new ObjectNotFoundException("Product not found with id " + productId));

            productFromDb.setName(saveProduct.getName());
            productFromDb.setPrice(saveProduct.getPrice());
            productFromDb.setStatus(Product.ProductStatus.ENABLED);

        Category category = new Category();
            category.setId(saveProduct.getCategoryId());
            productFromDb.setCategory(category);

        return productRepository.save(productFromDb);
    }

    @Override
    public Product disableOneById(Long productId) {
        Product productFromDb = productRepository.findById(productId).orElseThrow(
                () -> new ObjectNotFoundException("Product not found with id " + productId));

        productFromDb.setStatus(Product.ProductStatus.DISABLED);

        return productRepository.save(productFromDb);
    }

    @Override
    public Product enableOneById(Long productId) {
        Product productFromDb = productRepository.findById(productId).orElseThrow(
                () -> new ObjectNotFoundException("Product not found with id " + productId));

        productFromDb.setStatus(Product.ProductStatus.ENABLED);

        return productRepository.save(productFromDb);
    }

}