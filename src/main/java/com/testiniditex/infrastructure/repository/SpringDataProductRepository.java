package com.testiniditex.infrastructure.repository;


import com.testiniditex.infrastructure.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Integer> {
}