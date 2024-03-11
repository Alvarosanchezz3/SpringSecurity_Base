package com.alvaro.springsecurity.persistence.repository;

import com.alvaro.springsecurity.persistence.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
