package com.alvaro.springsecurity.controller;

import com.alvaro.springsecurity.dto.SaveProduct;
import com.alvaro.springsecurity.persistence.entitiy.Product;
import com.alvaro.springsecurity.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {

        Page<Product> productsPage = productService.findAll(pageable);

        if (productsPage.hasContent()) {
            return ResponseEntity.ok(productsPage);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findOneById(@PathVariable Long productId) {

        Optional<Product> product = productService.findOneById(productId);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createOne(@RequestBody @Valid SaveProduct saveProduct) {
        Product product = productService.create(saveProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateOneById(@PathVariable Long productId,
                                                 @RequestBody @Valid SaveProduct saveProduct) {
        Product product = productService.updateOneById(productId, saveProduct);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{productId}/disabled")
    public ResponseEntity<Product> disableOneById(@PathVariable Long productId) {
        Product product = productService.disableOneById(productId);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{productId}/enabled")
    public ResponseEntity<Product> enableOneById(@PathVariable Long productId) {
        Product product = productService.enableOneById(productId);
        return ResponseEntity.ok(product);
    }
}
