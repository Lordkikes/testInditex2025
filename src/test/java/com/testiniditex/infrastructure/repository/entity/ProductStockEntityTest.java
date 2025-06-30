package com.testiniditex.infrastructure.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductStockEntityTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        ProductStockEntity productStockEntity = new ProductStockEntity();
        ProductStockId productStockId = new ProductStockId(1, "S");
        productStockEntity.setId(productStockId);
        productStockEntity.setQuantity(10);

        // Act & Assert
        assertEquals(productStockId, productStockEntity.getId());
        assertEquals(10, productStockEntity.getQuantity());
    }

    @Test
    void testProductRelationship() {
        // Arrange
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setName("Product A");
        productEntity.setSalesUnits(100);

        ProductStockEntity productStockEntity = new ProductStockEntity();
        productStockEntity.setProduct(productEntity);

        // Act & Assert
        assertEquals(productEntity, productStockEntity.getProduct());
        assertEquals(1, productStockEntity.getProduct().getId());
        assertEquals("Product A", productStockEntity.getProduct().getName());
    }
}