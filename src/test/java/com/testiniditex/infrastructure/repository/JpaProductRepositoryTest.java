package com.testiniditex.infrastructure.repository;

import com.testiniditex.domain.model.Product;
import com.testiniditex.infrastructure.repository.entity.ProductEntity;
import com.testiniditex.infrastructure.repository.mapper.ProductEntityMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class JpaProductRepositoryTest {

    private final SpringDataProductRepository mockJpaRepository = mock(SpringDataProductRepository.class);
    private final ProductEntityMapper mockMapper = mock(ProductEntityMapper.class);
    private final JpaProductRepository repository = new JpaProductRepository(mockJpaRepository, mockMapper);

    @Test
    void testFindAll() {
        // Arrange
        ProductEntity entity1 = new ProductEntity();
        entity1.setId(1);
        entity1.setName("Product A");
        entity1.setSalesUnits(100);

        ProductEntity entity2 = new ProductEntity();
        entity2.setId(2);
        entity2.setName("Product B");
        entity2.setSalesUnits(200);

        when(mockJpaRepository.findAll()).thenReturn(List.of(entity1, entity2));

        Product product1 = new Product(1, "Product A", 100, null);
        Product product2 = new Product(2, "Product B", 200, null);

        when(mockMapper.toDomain(entity1)).thenReturn(product1);
        when(mockMapper.toDomain(entity2)).thenReturn(product2);

        // Act
        List<Product> products = repository.findAll();

        // Assert
        assertEquals(2, products.size());
        assertEquals(product1, products.get(0));
        assertEquals(product2, products.get(1));
    }
}