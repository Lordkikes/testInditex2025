package com.testiniditex.infrastructure.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProductStockIdTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        ProductStockId productStockId = new ProductStockId();
        productStockId.setProductId(1);
        productStockId.setSize("M");

        // Act & Assert
        assertEquals(1, productStockId.getProductId());
        assertEquals("M", productStockId.getSize());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        ProductStockId productStockId1 = new ProductStockId(1, "M");
        ProductStockId productStockId2 = new ProductStockId(1, "M");
        ProductStockId productStockId3 = new ProductStockId(2, "L");

        // Act & Assert
        assertEquals(productStockId1, productStockId2);
        assertEquals(productStockId1.hashCode(), productStockId2.hashCode());
        assertNotEquals(productStockId1, productStockId3);
        assertNotEquals(productStockId1.hashCode(), productStockId3.hashCode());
    }
}