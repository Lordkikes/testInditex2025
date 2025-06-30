package com.testiniditex.infrastructure.repository;

import com.testiniditex.domain.model.Product;
import com.testiniditex.domain.port.output.ProductRepository;
import com.testiniditex.infrastructure.repository.entity.ProductEntity;
import com.testiniditex.infrastructure.repository.mapper.ProductEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final SpringDataProductRepository jpaRepository;
    private final ProductEntityMapper mapper;

    public JpaProductRepository(SpringDataProductRepository jpaRepository,
                                ProductEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> entities = jpaRepository.findAll();
        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
