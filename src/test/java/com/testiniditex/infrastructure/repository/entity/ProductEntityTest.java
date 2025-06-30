package com.testiniditex.infrastructure.repository.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductEntityTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setName("Product A");
        productEntity.setSalesUnits(100);

        // Act & Assert
        assertEquals(1, productEntity.getId());
        assertEquals("Product A", productEntity.getName());
        assertEquals(100, productEntity.getSalesUnits());
    }

    @Test
    void testStockRelationship() {
        // Arrange
        ProductEntity productEntity = new ProductEntity();
        ProductStockEntity stockEntity1 = new ProductStockEntity();
        ProductStockEntity stockEntity2 = new ProductStockEntity();
        stockEntity1.setProduct(productEntity);
        stockEntity2.setProduct(productEntity);
        productEntity.setStock(List.of(stockEntity1, stockEntity2));

        // Act & Assert
        assertEquals(2, productEntity.getStock().size());
        assertEquals(productEntity, productEntity.getStock().get(0).getProduct());
        assertEquals(productEntity, productEntity.getStock().get(1).getProduct());
    }
}